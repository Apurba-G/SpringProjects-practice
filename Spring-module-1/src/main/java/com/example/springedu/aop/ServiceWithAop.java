package com.example.springedu.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springedu.core.GreetingService;

@Service
public class ServiceWithAop {
	
	@Autowired
	private GreetingService greetingService;
	public void testAop() {
        greetingService.sayHello();
    }
}
