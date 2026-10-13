package com.spring.ioc.lab.traditional;

public class OrderService {
	private CreditCardPayment payment = new CreditCardPayment(); // hard coded

	public void placeOrder(int amount) {
		System.out.println("Order Placed");
		payment.pay(amount);
	}

}
