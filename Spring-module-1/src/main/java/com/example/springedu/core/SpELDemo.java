package com.example.springedu.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Spring Expression Language
@Component
public class SpELDemo {

	@Value("#{systemProperties['user.name']}")
	private String userName;
	@Value("#{ T(java.lang.Math).random()*100}")
	private double randomNumber;
	@Value("#{greetingService.message}")
	private String greetingMessage;

	public void printSpELValues() {
		System.out.println("User (SpEL): " + userName);
		System.out.println("Random (SpEL): " + randomNumber);
		System.out.println("Greeting msg via SpEL: " + greetingMessage);
	}

}
