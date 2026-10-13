package com.example.internals.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.internals.config.AppConfig;
import com.example.internals.service.SampleService;

public class InternalsRunner {
	public static void main(String[] args) {
		System.out.println("===== Starting Spring Container =====");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("\n===== Container started. Retrieving bean. =====");
		SampleService service = ctx.getBean(SampleService.class);
		service.doSomething();

		System.out.println("\n===== Closing container. =====");
		ctx.close();
	}
}
