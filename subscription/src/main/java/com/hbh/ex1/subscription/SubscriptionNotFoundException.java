package com.hbh.ex1.subscription;

public class SubscriptionNotFoundException extends RuntimeException {
	SubscriptionNotFoundException(Long id) {
		super("Could not find subscription " + id);
	}
	
	SubscriptionNotFoundException(String customerName) {
		super("Could not find subscription for customerName: " + customerName);
	}
}
