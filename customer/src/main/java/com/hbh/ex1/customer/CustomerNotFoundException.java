package com.hbh.ex1.customer;

public class CustomerNotFoundException extends RuntimeException {
	CustomerNotFoundException(Long id) {
		super("Could not find customer with id:" + id);
	}
	
	CustomerNotFoundException(String customerName) {
		super("Could not find customer with name:" + customerName);
	}
}
