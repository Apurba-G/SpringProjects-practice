package com.spring.ioc.lab.iocprinciple;

public class IoCManualDemo {
	public static void main(String[] args) {
		
		PaymentService ccp = new CreditCardPayment();
		PaymentService dwp = new DigitalWalletPayment();
		IoCOrderService service;
		
		service = new IoCOrderService(ccp);
		service.placeOrder(500);
		
		// Change behavior by swapping implementation
		service = new IoCOrderService(dwp);
		service.placeOrder(300);
	}
}
