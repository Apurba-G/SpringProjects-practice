package com.example.lookup3.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lookup3.annotation.LookupConfig;
import com.example.lookup3.annotation.ShoppingCart;

public class LookupRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);

		ShoppingCart cart = ctx.getBean(ShoppingCart.class);
		
		 System.out.println("=== First checkout: Credit Card ===");
	      cart.checkoutWithCreditCard(100);

	      System.out.println("=== Second checkout: Digital Wallet ===");
	      cart.checkoutWithWallet(50);
	      
	      System.out.println("=== Third checkout: Credit Card again ===");
	      cart.checkoutWithCreditCard(200);

		ctx.close();

	}
}
