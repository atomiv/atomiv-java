package org.atomiv.template.lite.web.restapi.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private final long id;
	private final String firstName;
	private final String lastName;

	public CustomerDto(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
