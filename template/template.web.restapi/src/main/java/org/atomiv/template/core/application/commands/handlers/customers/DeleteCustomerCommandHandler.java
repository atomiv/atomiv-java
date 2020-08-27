package org.atomiv.template.core.application.commands.handlers.customers;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommand;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommandResponse;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Command;

public class DeleteCustomerCommandHandler
		implements Command.Handler<DeleteCustomerCommand, DeleteCustomerCommandResponse> {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DeleteCustomerCommandResponse handle(DeleteCustomerCommand command) {
		var id = new CustomerIdentity(command.getId());
		var exists = customerRepository.exists(id);

		if (!exists) {
			throw new ExistenceException(" Customer not found for this id: " + id);
		}

		customerRepository.remove(id);

		return new DeleteCustomerCommandResponse();
	}

}
