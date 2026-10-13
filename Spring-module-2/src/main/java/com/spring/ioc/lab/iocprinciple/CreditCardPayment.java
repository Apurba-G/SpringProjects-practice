package com.spring.ioc.lab.iocprinciple;

public class CreditCardPayment implements PaymentService{
	 public void pay(int amount) { System.out.println("CC: " + amount); }
}
