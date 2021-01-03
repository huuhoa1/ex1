package com.hbh.ex1.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	  @Bean
	  CommandLineRunner initDatabase(CustomerRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Customer("Bilbo Baggins", "62 bvd Magenta, Longueuil, QC, j4X1N9")));
	      log.info("Preloading " + repository.save(new Customer("Frodo Baggins", "64 bvd Magenta, Longueuil, QC, j4X1N9")));
	    };
	  }
}
