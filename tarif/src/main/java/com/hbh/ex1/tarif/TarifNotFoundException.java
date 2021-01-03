package com.hbh.ex1.tarif;

public class TarifNotFoundException extends RuntimeException {
	TarifNotFoundException(Long id) {
		super("Could not find tarif " + id);
	}
	
	TarifNotFoundException(String tarifName) {
		super("Could not find tarif " + tarifName);
	}
}
