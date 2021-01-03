package com.hbh.ex1.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// to return error 404 instead of 500 and nicer message when the id subscription is not found
@ControllerAdvice
public class CustomerNotFoundAdvice {
	  @ResponseBody
	  @ExceptionHandler(CustomerNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String subscriptionNotFoundHandler(CustomerNotFoundException ex) {
	    return ex.getMessage();
	  }
}
