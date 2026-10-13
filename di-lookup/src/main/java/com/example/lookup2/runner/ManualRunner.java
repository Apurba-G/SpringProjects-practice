package com.example.lookup2.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lookup2.manual.ManualConfig;
import com.example.lookup2.manual.ManualShoppingCart;

public class ManualRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ManualConfig.class);

		ManualShoppingCart cart = ctx.getBean(ManualShoppingCart.class);

		System.out.println("=== First checkout (manual) ===");
		cart.checkout(100);

		System.out.println("=== Second checkout (manual) ===");
		cart.checkout(200);

		ctx.close();
	}
}
