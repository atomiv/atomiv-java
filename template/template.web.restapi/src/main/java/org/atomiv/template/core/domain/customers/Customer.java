package org.atomiv.template.core.domain.customers;

import org.atomiv.framework.core.domain.Entity;

public class Customer extends Entity<CustomerIdentity> {

	private String firstName;
	private String lastName;

	public Customer(CustomerIdentity id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
