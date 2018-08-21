package com.abhi.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
public class Customer {
	private int id;
	private String name;
	private int phone;
	private String address;
	private float creditscore;
	
	
	
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



	public int getPhone() {
		return phone;
	}



	public void setPhone(int phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public float getCreditscore() {
		return creditscore;
	}



	public void setCreditscore(float creditscore) {
		this.creditscore = creditscore;
	}



	public Customer(int id, String name, int phone, String address, float creditscore) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.creditscore = creditscore;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", creditscore="
				+ creditscore + "]";
	}
	
	
	

}
