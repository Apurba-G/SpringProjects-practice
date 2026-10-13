package com.example.lookup3.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Every lookup returns a new instance
public class CreditCardPayment implements PaymentService {
	
	  public CreditCardPayment() {
	        System.out.println("CreditCardPayment instance created: " + this.hashCode());
	    }
	
	@Override
	public void pay(int amount) {
		System.out.println("CC: " + amount);
	}
}
