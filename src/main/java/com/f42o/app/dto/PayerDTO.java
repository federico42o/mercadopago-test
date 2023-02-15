package com.f42o.app.dto;

import com.mercadopago.resources.common.Address;
import com.mercadopago.resources.common.Phone;

public class PayerDTO {

//	@JsonProperty("first_name")
	private String name;
//	@JsonProperty("last_name")
	private String lastName;
	private String email;
	private Phone phone;
	private Address address;
	
	public PayerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayerDTO(String name, String lastName, String email, Phone phone, Address address) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
