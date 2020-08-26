package org.atomiv.template.infrastructure.queries.handlers.products.jpa;

import org.atomiv.template.core.application.queries.products.BrowseProductsQuery;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;
import org.atomiv.template.core.application.queries.products.ViewProductQuery;
import org.atomiv.template.core.application.queries.products.ViewProductQueryResponse;

import an.awesome.pipelinr.Command;

public class ViewProductQueryHandler implements Command.Handler<ViewProductQuery, ViewProductQueryResponse> {

	@Override
	public ViewProductQueryResponse handle(ViewProductQuery command) {
		
		
		/*
		 * 
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		return ResponseEntity.ok().body(product);
		 * 
		 * 
		 */
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
