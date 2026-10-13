package com.spring.ioc.lab.dependencyinjection;

public class DigitalWalletPayment implements PaymentService{
	public void pay(int amount) { System.out.println("Wallet: " + amount); }
}
