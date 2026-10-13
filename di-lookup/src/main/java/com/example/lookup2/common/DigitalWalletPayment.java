package com.example.lookup2.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Every lookup returns a new instance
public class DigitalWalletPayment implements PaymentService{
	public void pay(int amount) { 
		System.out.println("Wallet: " + amount);
		}
}
