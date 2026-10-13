package com.example.lookup2.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.lookup2.common.PaymentService;

@Component
public class ManualShoppingCart {
	 @Autowired
    private ApplicationContext context;
	 
	 public void checkout(int amount) {
	        System.out.println("Checkout started (manual lookup).");
	        PaymentService payment = context.getBean(PaymentService.class);   // <-- LOOKUP
	        payment.pay(amount);
	        System.out.println("Checkout complete.\n");
	    }

}
