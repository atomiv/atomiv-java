package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;
import org.atomiv.template.core.application.commands.products.EditProductCommand;
import org.atomiv.template.core.application.commands.products.EditProductCommandResponse;

import an.awesome.pipelinr.Command;

public class EditProductCommandHandler implements Command.Handler<EditProductCommand, EditProductCommandResponse> {

	@Override
	public EditProductCommandResponse handle(EditProductCommand command) {
		
		
		/*
		 * 
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setCode(productDetails.getCode());
		product.setDescription(productDetails.getDescription());
		product.setUnitPrice(productDetails.getUnitPrice());
		product.setIsListed(productDetails.getIsListed());
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
		 * 
		 */
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
