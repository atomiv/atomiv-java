package org.atomiv.template.infrastructure.queries.handlers.products.jpa;

import org.atomiv.template.core.application.queries.customers.BrowseCustomersQuery;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;
import org.atomiv.template.core.application.queries.products.BrowseProductsQuery;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;

import an.awesome.pipelinr.Command;

public class BrowseProductsQueryHandler implements Command.Handler<BrowseProductsQuery, BrowseProductsQueryResponse> {

	@Override
	public BrowseProductsQueryResponse handle(BrowseProductsQuery command) {
		
		/*
		var products = productRepository.findAll(); 
		return ResponseEntity.ok().body(products);
		 */
		
		// TODO Auto-generated method stub
		return null;
	}

}
