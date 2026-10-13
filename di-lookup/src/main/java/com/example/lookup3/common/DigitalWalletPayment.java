package com.example.lookup3.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Every lookup returns a new instance
public class DigitalWalletPayment implements PaymentService {

	public DigitalWalletPayment() {
		System.out.println("DigitalWalletPayment instance created: " + this.hashCode());
	}

	public void pay(int amount) {
		System.out.println("Wallet: " + amount);
	}
}
