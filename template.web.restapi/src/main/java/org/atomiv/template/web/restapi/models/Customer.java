package org.atomiv.template.web.restapi.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message="First name cannot be missing or empty")
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull(message="Last name cannot be missing or empty")
	@Column(name = "lastName")
	private String lastName;

	public Customer() {
		super();
	}

	public Customer(long id, String firstName, String lastName) {
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
	
//	@Override
//	public long hashCode() {
//		long hash = 7;
//		hash = 79 * hash + Objects.hashCode(this.id);
//		hash = 79 * hash + Objects.hashCode(this.firstName);
//		hash = 79 * hash + Objects.hashCode(this.lastName);
//		return hash;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) {
//			return true;
//			
//		}
//		if(obj == null) {
//			return false;
//			
//		}
//		final Customer other = (Customer) obj;
//		if(this.firstName != other.firstName) {
//			return false;
//			
//		}
//		
//		
//	}

}
