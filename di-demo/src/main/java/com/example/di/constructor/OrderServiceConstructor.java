package com.example.di.constructor;
import com.example.di.common.PaymentService;

public class OrderServiceConstructor {
	 private final PaymentService paymentService;
	 
	// Single constructor → Spring autowires automatically
	 public OrderServiceConstructor(PaymentService paymentObj) {
		 this.paymentService=paymentObj;
	 }
	 
	 public void placeOrder(int amount) {
		 paymentService.pay(amount);
	 }
	 
	 
	 
	 
	 
}
