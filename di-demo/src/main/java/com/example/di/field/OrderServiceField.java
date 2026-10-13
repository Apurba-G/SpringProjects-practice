package com.example.di.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.di.common.PaymentService;

@Component
public class OrderServiceField {
	@Autowired
	private PaymentService paymentService;
	
	  public void placeOrder(int amount) {
	        paymentService.pay(amount);
	    }
}
