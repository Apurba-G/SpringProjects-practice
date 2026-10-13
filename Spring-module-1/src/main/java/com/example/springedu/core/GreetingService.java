package com.example.springedu.core;

//Simple POJO
public class GreetingService {
	private String message;
	
	public void setMessage(String message) {
        this.message = message;
    }
	
	public String getMessage() {
	    return message;
	}

    public void sayHello() {
        System.out.println("Greeting: " + message);
    }
}
