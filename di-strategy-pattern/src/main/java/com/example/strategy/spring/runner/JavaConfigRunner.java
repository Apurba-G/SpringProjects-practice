package com.example.strategy.spring.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.strategy.spring.javaconfig.JavaStrategyConfig;
import com.example.strategy.spring.javaconfig.SorterService;

public class JavaConfigRunner {
	 public static void main(String[] args) {
	        AnnotationConfigApplicationContext ctx =
	                new AnnotationConfigApplicationContext(JavaStrategyConfig.class);
	        SorterService sorter = ctx.getBean(SorterService.class);
	        sorter.sort(new int[]{3, 1, 4});
	        ctx.close();
	    }
}
