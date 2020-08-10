package org.atomiv.template.infrastructure.persistence.jpa;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.atomiv.framework.infrastructure.jpa.Record;

@Entity
@Table(name = "customers")
public class CustomerRecord extends Record<UUID> {
	
	@NotNull
	@Size(min = 2, message = "First name cannot be missing or empty")
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
	@Size(min = 2, message = "Last name cannot be missing or empty")
	@Column(name = "lastName")
	private String lastName;

	public CustomerRecord() {
		super();
	}

	public CustomerRecord(UUID id, String firstName, String lastName) {
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
