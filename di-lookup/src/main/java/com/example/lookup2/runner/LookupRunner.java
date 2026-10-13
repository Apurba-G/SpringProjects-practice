package com.example.lookup2.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lookup2.annotation.LookupConfig;
import com.example.lookup2.annotation.ShoppingCart;

public class LookupRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);

		ShoppingCart cart = ctx.getBean(ShoppingCart.class);
		System.out.println("=== First checkout ===");
		cart.checkout(100);

		System.out.println("=== Second checkout ===");
		cart.checkout(200);

		ctx.close();

	}
}
