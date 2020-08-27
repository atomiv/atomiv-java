package org.atomiv.template.core.application.commands.customers;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class CreateCustomerCommand implements Command<CreateCustomerCommandResponse> {
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
}
