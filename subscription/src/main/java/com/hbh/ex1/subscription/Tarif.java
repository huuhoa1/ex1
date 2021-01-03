package com.hbh.ex1.subscription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Class to parse the result of rest call to Tarif Service
@JsonIgnoreProperties(ignoreUnknown = true)
class Tarif {
	private Long id;
	private String tarifName;

	Tarif() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarifName() {
		return tarifName;
	}

	public void setTarifName(String tarifName) {
		this.tarifName = tarifName;
	}


	
	  @Override
	  public String toString() {
	    return String.format(
	        "Tarif[id=%d, tarifName='%s']",
	        id, tarifName);
	  }
}
