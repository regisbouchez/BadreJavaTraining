package com.bnpparibas.training.optional.tp1;

import java.util.Optional;

public class PossibleNullAsIs {

	public static void main(String[] args) {
		Address address = new Address(Optional.ofNullable(null), "New York");
		Office office = new Office("OF1", address);
		Company company = new Company("Door Never Closed", office);

		Optional<String> maybeStreet = getStreet(company);
		maybeStreet.ifPresent(System.out::println);
	}

	private static Optional<String> getStreet(Company company) {
		Optional<String> streetAddress = null;
		if (company != null) {
			Office office = company.getOffice();
			if (office != null) {
				Address address = office.getAddress();
				if (address != null) {
					streetAddress = address.getStreet();
				}
			}
		}
		return streetAddress;
	}
}
