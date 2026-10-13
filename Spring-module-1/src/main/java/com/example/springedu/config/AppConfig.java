package com.example.springedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.springedu.core.GreetingService;

@Configuration
@ComponentScan(basePackages = {
         "com.example.springedu.core",
         "com.example.springedu.data",
         "com.example.springedu.aop"
})
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	public GreetingService greetingService() {
		GreetingService service = new GreetingService();
		service.setMessage("Hello from Java Configuration!");
		return service;
	}
}
