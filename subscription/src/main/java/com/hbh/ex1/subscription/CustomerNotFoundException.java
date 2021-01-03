package com.hbh.ex1.subscription;

public class CustomerNotFoundException extends RuntimeException {
	CustomerNotFoundException(String customerName) {
		super("AccountService: could not find customer: " + customerName );
	}
}