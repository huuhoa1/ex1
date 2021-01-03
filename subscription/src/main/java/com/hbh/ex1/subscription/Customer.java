package com.hbh.ex1.subscription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Class to parse the result of rest call to Customer Service
@JsonIgnoreProperties(ignoreUnknown = true)
class Customer {
	private Long id;
	private String customerName;
	private String address;

	Customer() {
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
