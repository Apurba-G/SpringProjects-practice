package com.example.lookup2.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import com.example.lookup2.common.PaymentService;
//THIS IS singleton CLASS
@Component
public abstract class ShoppingCart {
	
	public void checkout(int amount) {
        System.out.println("Checkout started.");
        PaymentService payment = createPaymentService();   // <-- LOOKUP
        payment.pay(amount);
        System.out.println("Checkout complete.\n");
    }

    @Lookup
    protected abstract PaymentService createPaymentService();
}
