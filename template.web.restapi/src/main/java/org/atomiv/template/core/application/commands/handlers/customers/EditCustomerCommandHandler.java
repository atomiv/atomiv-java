package org.atomiv.template.core.application.commands.handlers.customers;

import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommand;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommandResponse;
import org.atomiv.template.core.application.commands.customers.EditCustomerCommand;
import org.atomiv.template.core.application.commands.customers.EditCustomerCommandResponse;

import an.awesome.pipelinr.Command;

public class EditCustomerCommandHandler implements Command.Handler<EditCustomerCommand, EditCustomerCommandResponse> {

	@Override
	public EditCustomerCommandResponse handle(EditCustomerCommand command) {
		
		/*
		 * 		CustomerRecord customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customerRepository.save(customer);
		return ResponseEntity.ok().body(customer); 
		 *
		 */
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
