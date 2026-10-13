package com.example.internals.service;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class SampleService {
	
	public SampleService() {
        System.out.println("SampleService constructor called.");
    }

    @PostConstruct
    public void init() {
        System.out.println("SampleService @PostConstruct method called.");
    }

    public void doSomething() {
        System.out.println("SampleService.doSomething() executed.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SampleService @PreDestroy method called.");
    }
}
