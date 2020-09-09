package org.atomiv.template.lite.web.restapi.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String firstName;
	private String lastName;

	public CustomerDto() {

	}

	public CustomerDto(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
