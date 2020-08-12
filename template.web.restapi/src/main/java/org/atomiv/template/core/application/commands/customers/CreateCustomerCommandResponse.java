package org.atomiv.template.core.application.commands.customers;

import lombok.Getter;
import lombok.Setter;

public class CreateCustomerCommandResponse {

	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
}
