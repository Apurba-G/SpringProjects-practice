package com.example.springedu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("excution(* com.example.springedu.core.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		 System.out.println("[AOP] Before: " + joinPoint.getSignature().getName());
	}
	@AfterReturning(pointcut ="execution(* com.example.springedu.core.GreetingService.sayHello(..))", returning = "result")
	public void logAfterGreeting(JoinPoint joinPoint, Object result) {
		System.out.println("[AOP] After greeting method");
	}
	
	
	
	

}
