package com.example.springedu.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class XmlConfigDemo {

	public void demonstrateXmlConfig() {
		// Load XML config (demonstrates Spring's XML support)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		GreetingService service = ctx.getBean("xmlGreetingService", GreetingService.class);
		service.sayHello();
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
