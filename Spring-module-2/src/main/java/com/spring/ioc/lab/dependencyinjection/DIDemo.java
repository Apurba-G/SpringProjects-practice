package com.spring.ioc.lab.dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIDemo {
	public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("di-config.xml");
		 
		 OrderServiceConstructor osc = ctx.getBean(OrderServiceConstructor.class);
		 osc.placeOrder(100);
		 
		 OrderServiceSetter oss = ctx.getBean("setterInjected", OrderServiceSetter.class);
	     oss.placeOrder(200);
	}
}
