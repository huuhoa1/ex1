package com.hbh.ex1.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Customer {
	private @Id @GeneratedValue Long id;
	private String customerName;
	private String address;

	Customer() {
	}

	Customer(String customerName, String address) {
		this.customerName = customerName;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	  @Override
	  public String toString() {
	    return String.format(
	        "Customer[id=%d, customerName='%s', address='%s']",
	        id, customerName, address);
	  }
}
