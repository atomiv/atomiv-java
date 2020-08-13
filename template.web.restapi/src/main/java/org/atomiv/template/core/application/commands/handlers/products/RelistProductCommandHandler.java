package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.template.core.application.commands.products.EditProductCommand;
import org.atomiv.template.core.application.commands.products.EditProductCommandResponse;
import org.atomiv.template.core.application.commands.products.RelistProductCommand;
import org.atomiv.template.core.application.commands.products.RelistProductCommandResponse;

import an.awesome.pipelinr.Command;

public class RelistProductCommandHandler implements Command.Handler<RelistProductCommand, RelistProductCommandResponse> {

	@Override
	public RelistProductCommandResponse handle(RelistProductCommand command) {
		
		
		/*
		 * 
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setIsListed(true);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
		 * 
		 */
		
		// TODO Auto-generated method stub
		return null;
	}

}
