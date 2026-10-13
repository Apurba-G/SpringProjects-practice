package com.example.di.setter;
import com.example.di.common.PaymentService;

public class OrderServiceSetter {
	 private PaymentService paymentService;
	 
	// Setter
	 public void setPaymentService(PaymentService paymentService) {
	        this.paymentService = paymentService;
	    }
	 
	 
	 public void placeOrder(int amount) {
		 if(paymentService != null) {
			 paymentService.pay(amount);
		 }else{
			 System.out.println("No payment service configured");
		 }
	 }
}
