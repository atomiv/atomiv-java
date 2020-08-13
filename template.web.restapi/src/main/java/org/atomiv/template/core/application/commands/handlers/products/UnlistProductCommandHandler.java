package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.template.core.application.commands.products.RelistProductCommand;
import org.atomiv.template.core.application.commands.products.RelistProductCommandResponse;
import org.atomiv.template.core.application.commands.products.UnlistProductCommand;
import org.atomiv.template.core.application.commands.products.UnlistProductCommandResponse;

import an.awesome.pipelinr.Command;

public class UnlistProductCommandHandler implements Command.Handler<UnlistProductCommand, UnlistProductCommandResponse> {

	@Override
	public UnlistProductCommandResponse handle(UnlistProductCommand command) {
		
		/*
		 * 
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setIsListed(false);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
		 * 
		 */
		
		// TODO Auto-generated method stub
		return null;
	}

}
