package com.spring.ioc.lab.dependencyinjection;

public class OrderServiceSetter {
	private PaymentService paymentService;

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void placeOrder(int amount) {
		paymentService.pay(amount);
	}
}
