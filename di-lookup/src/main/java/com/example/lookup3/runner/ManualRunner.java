package com.example.lookup3.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lookup3.manual.ManualConfig;
import com.example.lookup3.manual.ManualShoppingCart;

public class ManualRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ManualConfig.class);

		ManualShoppingCart cart = ctx.getBean(ManualShoppingCart.class);

	    System.out.println("=== First checkout: credit ===");
        cart.checkout("credit", 100);

        System.out.println("=== Second checkout: wallet ===");
        cart.checkout("wallet", 50);
        
        System.out.println("=== Third checkout: credit again ===");
        cart.checkout("credit", 200);


		ctx.close();
	}
}
