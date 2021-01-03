package com.hbh.ex1.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}
	
/*	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		//return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
		return builder.build();
	} */
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

}
