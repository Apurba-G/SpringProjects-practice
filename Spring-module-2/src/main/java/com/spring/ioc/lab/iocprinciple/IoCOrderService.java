package com.spring.ioc.lab.iocprinciple;

public class IoCOrderService {
	private final PaymentService paymentService;

	public IoCOrderService(PaymentService paymentService) {
		this.paymentService = paymentService; // dependency injected
	}

	public void placeOrder(int amount) {
		System.out.println("Order placed.");
		paymentService.pay(amount);
	}
}
