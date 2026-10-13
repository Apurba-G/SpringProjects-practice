DefaultListableBeanFactory is the most complete implementation of Spring’s BeanFactory. It can be used entirely programmatically, without any XML or annotations.

Lazy initialization is the default behaviour of BeanFactory. Beans are created only on demand (when getBean() is called, or when another bean depends on them).

ApplicationContext, by contrast, pre‑instantiates all singleton beans eagerly at startup (unless marked @Lazy).

This example shows how Spring’s core container works behind the scenes – BeanFactory is the foundation on which ApplicationContext is built.