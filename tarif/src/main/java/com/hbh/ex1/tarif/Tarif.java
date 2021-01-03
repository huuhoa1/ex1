package com.hbh.ex1.tarif;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Tarif {
	private @Id @GeneratedValue Long id;
	private String tarifName;

	Tarif() {
	}

	Tarif(String tarifName) {
		this.tarifName = tarifName;
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
		return String.format("Tarif[id=%d, tarifName='%s']", id, tarifName);
	}
}
