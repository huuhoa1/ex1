package com.hbh.ex1.subscription;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${customers.url}")
	String customersURL;

	public void testMethod() {
		System.out.println("Inside CustomerService: test method");
	}

	public Optional<Customer> checkCustomerName(String customerName) {

		System.out.println("customerName: " + customerName);
		// String url = "http://localhost:8081/customers/name/" + customerName;
		String url = customersURL + customerName;
		try {
			return Optional.ofNullable(restTemplate.getForObject(url, Customer.class));
		} catch (RestClientException e) {
			return Optional.empty();
		}
	}

}
