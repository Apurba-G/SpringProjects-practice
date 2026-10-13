package com.example.di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorRunner {
	 public static void main(String[] args) {
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("constructor-config.xml");
		 OrderServiceConstructor service=ctx.getBean(OrderServiceConstructor.class);
		 service.placeOrder(150);
	 }
}
