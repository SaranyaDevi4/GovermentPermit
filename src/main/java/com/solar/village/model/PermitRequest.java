package com.solar.village.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PermitRequest {
	@JsonProperty
	int id;
	
	@JsonProperty
	String name;
	
	@JsonProperty
	String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PermitRequest [id=" + id + ", name=" + name + ", address=" + address 
				+ "]";
	}
}
