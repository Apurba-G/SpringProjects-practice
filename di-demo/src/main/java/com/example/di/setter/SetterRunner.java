package com.example.di.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SetterRunner {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("setter-config.xml");
		OrderServiceSetter service = ctx.getBean(OrderServiceSetter.class);
		service.placeOrder(200);
	}
}
