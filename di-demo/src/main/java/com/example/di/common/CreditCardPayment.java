package com.example.di.common;

public class CreditCardPayment implements PaymentService {
	@Override
	public void pay(int amount) {
		System.out.println("CC: " + amount);
	}
}
