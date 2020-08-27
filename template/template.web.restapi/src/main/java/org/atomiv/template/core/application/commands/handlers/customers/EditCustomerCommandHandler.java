package org.atomiv.template.core.application.commands.handlers.customers;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.commands.customers.EditCustomerCommand;
import org.atomiv.template.core.application.commands.customers.EditCustomerCommandResponse;
import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Command;

public class EditCustomerCommandHandler implements Command.Handler<EditCustomerCommand, EditCustomerCommandResponse> {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EditCustomerCommandResponse handle(EditCustomerCommand command) {
		var id = new CustomerIdentity(command.getId());
		var customer = customerRepository.find(id);

		if (customer == null) {
			throw new ExistenceException(" Customer not found for this id: " + id);
		}

		Update(customer, command);

		customerRepository.update(customer);

		return modelMapper.map(customer, EditCustomerCommandResponse.class);
	}

	private void Update(Customer customer, EditCustomerCommand command) {
		var firstName = command.getFirstName();
		var lastName = command.getLastName();

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
	}

}
