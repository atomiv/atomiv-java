package org.atomiv.template.core.application.commands.handlers.customers;

import java.util.UUID;

import org.atomiv.template.core.application.commands.customers.CreateCustomerCommand;
import org.atomiv.template.core.application.commands.customers.CreateCustomerCommandResponse;
import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class CreateCustomerCommandHandler
		implements Command.Handler<CreateCustomerCommand, CreateCustomerCommandResponse> {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CreateCustomerCommandResponse handle(CreateCustomerCommand command) {
		var customerId = new CustomerIdentity(UUID.randomUUID());
		var firstName = command.getFirstName();
		var lastName = command.getLastName();
		var customer = new Customer(customerId, firstName, lastName);

		customerRepository.add(customer);

		return modelMapper.map(customer, CreateCustomerCommandResponse.class);
	}

}
