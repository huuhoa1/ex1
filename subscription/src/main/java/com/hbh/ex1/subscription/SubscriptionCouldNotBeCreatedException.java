package com.hbh.ex1.subscription;

public class SubscriptionCouldNotBeCreatedException extends RuntimeException {
	SubscriptionCouldNotBeCreatedException(String msg) {
		super("Could not create subscription: " + msg);
	}
}
