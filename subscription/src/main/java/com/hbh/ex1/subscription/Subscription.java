package com.hbh.ex1.subscription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Subscription {
	private @Id @GeneratedValue Long id;
	private String customerName;
	private String tarifName;

	Subscription() {
	}

	Subscription(String customerName, String tarifName) {
		this.customerName = customerName;
		this.tarifName = tarifName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	        "Subscription[id=%d, customerName='%s', tarifName='%s']",
	        id, customerName, tarifName);
	  }
}
