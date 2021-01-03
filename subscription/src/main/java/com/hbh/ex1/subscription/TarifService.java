package com.hbh.ex1.subscription;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class TarifService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value( "${tarifs.url}")
	String tarifsURL;
	
	public void testMethod() {
		System.out.println("Inside TarifService: test method");
	}
	
	public Optional<Tarif> checkTarifName(String tarifName) {
		
		System.out.println("tarifName: " + tarifName);
		//String url = "http://localhost:8081/tarifs/name/" + tarifName;
		String url = tarifsURL + tarifName;
		try {
			return Optional.ofNullable(restTemplate.getForObject(url, Tarif.class));
		} catch (RestClientException e) {
			return Optional.empty();
		}
	}

}
