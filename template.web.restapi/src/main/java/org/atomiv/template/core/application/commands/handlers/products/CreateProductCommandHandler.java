package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.template.core.application.commands.customers.CreateCustomerCommand;
import org.atomiv.template.core.application.commands.customers.CreateCustomerCommandResponse;
import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;

import an.awesome.pipelinr.Command;

public class CreateProductCommandHandler implements Command.Handler<CreateProductCommand, CreateProductCommandResponse> {

	@Override
	public CreateProductCommandResponse handle(CreateProductCommand command) {
		
		/*
		 *
		product.setIsListed(true);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
		 *
		 */
		
		// TODO Auto-generated method stub
		return null;
	}

}
