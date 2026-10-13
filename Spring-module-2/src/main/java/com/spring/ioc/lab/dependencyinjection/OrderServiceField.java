package com.spring.ioc.lab.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceField {

	@Autowired
	private PaymentService paymentService;

	public void placeOrder(int amount) {
		paymentService.pay(amount);
	}
}
