package com.spring.ioc.lab.traditional;

public class TraditionalMain {
	public static void main(String[] args) {
        OrderService service = new OrderService();
        service.placeOrder(500);
    }
}
