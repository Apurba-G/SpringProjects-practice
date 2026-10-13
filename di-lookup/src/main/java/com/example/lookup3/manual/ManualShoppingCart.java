package com.example.lookup3.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.lookup3.common.PaymentService;

@Component
public class ManualShoppingCart {
	 @Autowired
    private ApplicationContext context;
	 
	 public void checkout(String paymentType, int amount) {
		 System.out.println("Checkout using " + paymentType);
		 PaymentService payment;
		 
		 if ("credit".equalsIgnoreCase(paymentType)) {
	            payment = context.getBean("creditCardPayment", PaymentService.class);
	        } else if ("wallet".equalsIgnoreCase(paymentType)) {
	            payment = context.getBean("digitalWalletPayment", PaymentService.class);
	        } else {
	            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
	        }
	        payment.pay(amount);
		 
		 
		 
		 
	    }

}
