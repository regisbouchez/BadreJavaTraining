package com.bnpparibas.training.optional.tp1;

import java.util.Optional;

public class Address {
	private Optional<String> street;
	private String city;

	public Address(Optional<String> street, String city) {
		this.street = street;
		this.city = city;
	}

	public Optional<String> getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}
}
