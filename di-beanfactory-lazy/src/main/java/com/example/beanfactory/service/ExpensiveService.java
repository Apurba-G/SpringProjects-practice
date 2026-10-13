package com.example.beanfactory.service;

public class ExpensiveService {
	public ExpensiveService() {
        System.out.println("ExpensiveService instance created: " + this.hashCode());
    }

    public void doWork() {
        System.out.println("ExpensiveService.doWork() called.");
    }
}
