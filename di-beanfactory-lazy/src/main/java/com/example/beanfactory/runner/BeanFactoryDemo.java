package com.example.beanfactory.runner;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.example.beanfactory.service.ExpensiveService;

public class BeanFactoryDemo {
	public static void main(String[] args) {
		System.out.println("=== Creating DefaultListableBeanFactory ===");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		// Register a bean definition (like a recipe)
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ExpensiveService.class);
		factory.registerBeanDefinition("expensiveService", builder.getBeanDefinition());

		System.out.println("\nBean definition registered. No bean created yet.");

		// At this point, ExpensiveService constructor hasn't been called.
		// This is lazy initialization.

		System.out.println("\n>>> Fetching bean for the first time...");
		ExpensiveService service1 = factory.getBean("expensiveService", ExpensiveService.class);
		service1.doWork();

		System.out.println("\n>>> Fetching bean for the second time...");
		ExpensiveService service2 = factory.getBean("expensiveService", ExpensiveService.class);
		service2.doWork();

		// Both references point to the same instance (singleton by default)
		System.out.println("\nAre both references the same? " + (service1 == service2));
		System.out.println("\nHash Code of Service-1? " + service1.hashCode());
		System.out.println("\nHash Code of Service-2? " + service2.hashCode());

		System.out.println("\n=== End of demo ===");

	}
}
