package com.example.di.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FieldRunner {
	 public static void main(String[] args) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("field-config.xml");
	        OrderServiceField service = ctx.getBean(OrderServiceField.class);
	        service.placeOrder(300);
	    }
}
