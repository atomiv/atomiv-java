package org.atomiv.template.core.application.commands.handlers.customers;

import org.atomiv.template.core.application.commands.customers.CreateCustomerCommand;
import org.atomiv.template.core.application.commands.customers.CreateCustomerCommandResponse;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommand;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommandResponse;

import an.awesome.pipelinr.Command;

public class DeleteCustomerCommandHandler implements Command.Handler<DeleteCustomerCommand, DeleteCustomerCommandResponse> {

	@Override
	public DeleteCustomerCommandResponse handle(DeleteCustomerCommand command) {
		
		/*
		 *
		customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		customerRepository.deleteById(customerId);
		return ResponseEntity.ok().build();
		 *
		 */
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
