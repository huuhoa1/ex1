package com.hbh.ex1.tarif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(TarifRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Tarif("tarifD")));
			log.info("Preloading " + repository.save(new Tarif("tarifDyna1")));
			log.info("Preloading " + repository.save(new Tarif("tarifDyna2")));
			log.info("Preloading " + repository.save(new Tarif("tarifFlex1")));
			log.info("Preloading " + repository.save(new Tarif("tarifFlex2")));
		};
	}
}
