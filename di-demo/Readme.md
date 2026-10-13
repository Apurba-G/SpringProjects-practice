## What This Demonstrates

- **Constructor Injection** – mandatory dependency, `final` field, fully initialised object.
- **Setter Injection** – optional dependency, object can exist without it, configurable after creation.
- **Field Injection** – quick and dirty, works only inside a Spring container, hides dependencies.
- **Testing advantage** – the constructor‑injected service can be tested without Spring, using plain Mockito.

Run all three runners to see the same output: `Paid X via Credit Card.`, each using a different injection style.

---

## 1. The Big Picture

When you ask the container for a bean (or when it eagerly creates a singleton), the container must:

1. **Load** the bean’s definition (blueprint).
2. **Create** an instance of the bean.
3. **Resolve** all its dependencies (other beans it needs).
4. **Inject** those dependencies into the bean.
5. **Call** any initialisation callbacks.

All of this happens inside the `AbstractAutowireCapableBeanFactory` – the workhorse of Spring’s container.

---

## 2. Step‑by‑Step for a Single Bean

Suppose you have this simple class:

```java
@Component
public class OrderService {
    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    // ...
}
```

When the container decides to create the `OrderService` bean, the following occurs:

### Step 1: Read the Bean Definition

The container already knows about `OrderService` because it was detected during component scanning (or defined in XML). Internally, a `BeanDefinition` object holds everything needed: class name, constructor parameters, scope, etc.

### Step 2: Determine Constructor to Use

Spring uses the `@Autowired` annotation (or, since Spring 4.3, it automatically chooses a single constructor if the class has only one) to decide which constructor to invoke. The `AutowiredAnnotationBeanPostProcessor` marks the constructor as “autowired”.

### Step 3: Resolve Constructor Arguments

The container must supply a `PaymentService` instance to the constructor. It does that by looking into the container for a bean of type `PaymentService`.

- It searches the **bean factory** for all beans that match the type (`PaymentService`).
- If exactly one is found, it uses that.
- If none, it throws an exception (unless `@Autowired(required = false)`).
- If multiple, it tries to pick the **primary** bean (marked with `@Primary`) or a bean whose name matches the parameter name (if `@Qualifier` is used).

The dependency resolution is **recursive** – if `PaymentService` itself has dependencies, the container creates it first.

### Step 4: Instantiate the Bean

Once all constructor arguments are resolved, Spring creates a new instance of `OrderService` using reflection:

```
Constructor.newInstance(resolvedArgs...)
```

At this point, the `OrderService` object exists, and its `paymentService` field already has a value (because constructor injection sets the field immediately).

### Step 5: Apply Field and Setter Injection (if any)

After the constructor runs, the bean is **not yet ready**. Spring now looks for `@Autowired` on fields and setter methods.

- For **field injection**: the `AutowiredAnnotationBeanPostProcessor` uses reflection to set the field directly, bypassing any setter.
- For **setter injection**: it calls the setter method with the resolved dependency.

This step happens **after** the constructor, so any field‑injected dependencies are **null** inside the constructor. That’s why constructor injection is safer.

### Step 6: Call BeanPostProcessors (before initialisation)

Spring passes the bean through all `BeanPostProcessor.postProcessBeforeInitialization()` methods. This is where `@PostConstruct` is handled, for example, but it’s not injection itself.

### Step 7: Call Initialisation Callbacks

`InitializingBean.afterPropertiesSet()` or a custom `init-method` is invoked. Now the bean is fully initialised and ready.

---

## 3. Dependency Resolution Mechanism in Detail

When the container needs a bean of a certain type (e.g., `PaymentService`), it goes through these rules:

- **By Type:** The main lookup is by the declared type of the dependency (the interface or class). Spring scans all beans of that type.
- **Qualifiers:** If `@Qualifier("paypal")` is present, Spring narrows the candidates to the one with that qualifier value.
- **Generics:** Spring resolves generic types (e.g., `List<PaymentService>`) by injecting all beans of that type.
- **Primary:** Among multiple candidates, the one annotated with `@Primary` wins.
- **ByName fallback:** If no qualifier is present and multiple beans exist, Spring tries to match the **parameter name** (for constructor/setter) or **field name** (for field injection) to a bean name. This is why naming conventions matter.
- **Ordered collections:** If the dependency is an array, `List`, or `Map`, Spring injects all matching beans.

If no bean matches, Spring throws `NoSuchBeanDefinitionException` (unless the injection point is marked `required = false`).

---

## 4. Circular Dependencies

What if `Bean A` needs `Bean B`, and `Bean B` needs `Bean A`? For **singleton** beans, Spring can resolve circular dependencies using **early references**.

1. Spring creates the first bean (e.g., `A`) using its default constructor (if any).
2. It caches an **early reference** to `A` (an unfinished, raw instance).
3. It then tries to inject `B` into `A`. To get `B`, it starts creating `B`.
4. While creating `B`, it finds a dependency on `A`. Instead of a fresh instance, it uses the **early reference** of `A` it cached earlier.
5. `B` finishes creation, is injected into `A`, and both beans are fully initialized.

This works only for **singleton scope** and **setter/field injection**. Constructor injection usually fails with circular dependencies because the constructor needs a finished bean immediately.

---

## 5. Injection Timing

| Injection Type | When It Happens |
| --- | --- |
| Constructor injection | During bean instantiation (before the object is fully constructed) |
| Setter injection | After instantiation, before `@PostConstruct` |
| Field injection | Same as setter injection (via reflection, after instantiation) |

Because constructor injection happens first, you can use the dependencies immediately inside the constructor or other methods. With setter/field injection, do not expect dependencies to be available inside the constructor – they are still `null` at that point.

---

## 6. Example: Following the Log

If you enable debug logging (`logging.level.org.springframework.beans=DEBUG`), you can trace how Spring resolves dependencies:

```
Creating instance of bean 'orderService'
Autowiring by type from bean name 'orderService' via constructor
  to bean named 'creditCardPayment'
Finished creating instance of bean 'orderService'
```

This shows the exact resolution path.

---

## 7. Summary of the DI Process

1. **Container reads** `BeanDefinition`.
2. **Resolves** all dependencies needed for instantiation (constructor).
3. **Creates** the bean via reflection.
4. **Injects** remaining dependencies (setters, fields) using `BeanPostProcessor`s.
5. **Invokes** life‑cycle callbacks.
6. **Returns** the fully‑wired bean.

Every bean you get from the container has gone through this exact process, whether it’s a simple `@Service` or a complex graph of objects. This is the “magic” of Spring’s IoC – a deterministic, configurable, and extensible engine that **inverts** the control of object creation and wiring from your code to the framework.