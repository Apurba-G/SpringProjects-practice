package com.example.appcontext.classpathxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.appcontext.common.GreetingService;

public class ClassPathXmlDemo {
	 public static void main(String[] args) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath-context.xml");
	        GreetingService gs = ctx.getBean(GreetingService.class);
	        gs.greet();
	    }
}
