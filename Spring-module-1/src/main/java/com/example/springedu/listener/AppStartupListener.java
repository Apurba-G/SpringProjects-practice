package com.example.springedu.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.springedu.aop.ServiceWithAop;
import com.example.springedu.core.SpELDemo;
import com.example.springedu.core.XmlConfigDemo;

@Component
public class AppStartupListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SpELDemo spelDemo;
	@Autowired
	private XmlConfigDemo xmlConfigDemo;
	@Autowired
	private ServiceWithAop serviceWithAop;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// Avoid double invocation (root context vs web context)
		if (event.getApplicationContext().getParent() == null) {
			System.out.println("\n========== SPRING TEACHING MODULE 1 (PURE SPRING) ==========");
			System.out.println("=== Core Container Demo ===");
			// GreetingService is also autowired, but we already have it. Let's get it from
			// context.
			var greetingService = event.getApplicationContext().getBean("greetingService",
					com.example.springedu.core.GreetingService.class);

			greetingService.sayHello();

			System.out.println("\n=== SpEL Demo ===");
			spelDemo.printSpELValues();

			System.out.println("\n=== XML Config Demo ===");
			xmlConfigDemo.demonstrateXmlConfig();

			System.out.println("\n=== AOP Demo ===");
			serviceWithAop.testAop();

			System.out.println("\n=== Web Module ===");
			System.out.println("Web application started. Access: http://localhost:8080/spring-teaching-module1/api/hello");

			System.out.println("=============================================================\n");

		}

	}

}
