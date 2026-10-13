package com.spring.ioc.lab.dependencyinjection;

public class OrderServiceConstructor {
	private final PaymentService paymentService;

	public OrderServiceConstructor(PaymentService paymentService) {
		this.paymentService = paymentService;// dependency injected
	}

	public void placeOrder(int amount) {
		paymentService.pay(amount);
	}
}
