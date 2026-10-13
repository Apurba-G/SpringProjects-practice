package com.spring.ioc.lab.dependencyinjection;

public class CreditCardPayment implements PaymentService{
	 public void pay(int amount) { System.out.println("CC: " + amount); }
}
