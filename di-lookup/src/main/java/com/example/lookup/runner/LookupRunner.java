package com.example.lookup.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lookup.config.AppConfig;
import com.example.lookup.service.CommandManager;

public class LookupRunner {
	 public static void main(String[] args) {
	        AnnotationConfigApplicationContext ctx =
	                new AnnotationConfigApplicationContext(AppConfig.class);

	        CommandManager manager = ctx.getBean(CommandManager.class);

	        System.out.println("=== First call ===");
	        manager.process();

	        System.out.println("=== Second call ===");
	        manager.process();

	        System.out.println("=== Third call ===");
	        manager.process();

	        ctx.close();
	    }
	
}
