package se.coredev.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Customer {

	private final Long id;
	private final String firstName;
	private final String lastName;
	private final String customerNumber;

	public Customer(Long id, String firstName, String lastName, String customerNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerNumber = customerNumber;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += id.hashCode() * 37;
		result += customerNumber.hashCode() * 37;

		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Customer) {
			Customer c = (Customer) other;
			return id.equals(c.id) && customerNumber.equals(c.customerNumber);
		}

		return false;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
