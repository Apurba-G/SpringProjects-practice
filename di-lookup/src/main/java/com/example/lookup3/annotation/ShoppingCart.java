package com.example.lookup3.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import com.example.lookup3.common.PaymentService;
//THIS IS singleton CLASS
@Component
public abstract class ShoppingCart {
	
	public void checkoutWithCreditCard(int amount) {
		System.out.println("Checkout started with Credit Card...");
        PaymentService payment = createCreditCardPayment();   // <-- LOOKUP
        payment.pay(amount);
        System.out.println("Checkout complete.\n");
	}
	
	public void checkoutWithWallet(int amount) {
		System.out.println("Checkout started with Digital Wallet...");
        PaymentService payment = createWalletPayment();   // <-- LOOKUP
        payment.pay(amount);
        System.out.println("Checkout complete.\n");
	}
	

    @Lookup("creditCardPayment")
    protected abstract PaymentService createCreditCardPayment();
    
    @Lookup("digitalWalletPayment")
    protected abstract PaymentService createWalletPayment();
}
