package org.atomiv.template.infrastructure.queries.handlers.customers.jpa;

import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQuery;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;

import an.awesome.pipelinr.Command;

public class BrowseCustomersQueryHandler implements Command.Handler<BrowseCustomersQuery, BrowseCustomersQueryResponse> {

	@Override
	public BrowseCustomersQueryResponse handle(BrowseCustomersQuery command) {
		// TODO Auto-generated method stub
		return null;
		
		/*
		var customers = customerRepository.findAll();
		
		var responseRecords = modelMapper.map(customers, new TypeToken<List<BrowseCustomersQueryResponseRecord>>() {}.getType());
		
		var response
		
		return ResponseEntity.ok().body(customers);
		*/
	}

}
