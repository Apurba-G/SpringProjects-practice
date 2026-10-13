package com.spring.ioc.lab.iocprinciple;

public class DigitalWalletPayment implements PaymentService{
	public void pay(int amount) { System.out.println("Wallet: " + amount); }
}
