package org.atomiv.template.core.application.commands.customers;

import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class DeleteCustomerCommand implements Command<DeleteCustomerCommandResponse> {
	@Getter
	@Setter
	private UUID id;
}
