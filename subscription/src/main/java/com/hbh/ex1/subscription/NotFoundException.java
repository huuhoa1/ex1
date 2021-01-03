package com.hbh.ex1.subscription;

public class NotFoundException extends RuntimeException {
	NotFoundException() {
		super("restTemplate Could not find requested object");
	}
}