package com.example.di.common;

public class DigitalWalletPayment implements PaymentService{
	public void pay(int amount) { 
		System.out.println("Wallet: " + amount);
		}
}
