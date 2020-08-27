package org.atomiv.template.core.application.commands.customers;

import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class EditCustomerCommand implements Command<EditCustomerCommandResponse> {
	@Getter
	@Setter
	private UUID id;
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
}
