package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.commands.products.EditProductCommand;
import org.atomiv.template.core.application.commands.products.EditProductCommandResponse;
import org.atomiv.template.core.application.commands.products.RelistProductCommand;
import org.atomiv.template.core.application.commands.products.RelistProductCommandResponse;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.atomiv.template.core.domain.products.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Command;

public class RelistProductCommandHandler implements Command.Handler<RelistProductCommand, RelistProductCommandResponse> {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public RelistProductCommandResponse handle(RelistProductCommand command) {
		var id = new ProductIdentity(command.getId());
		var product = productRepository.find(id);
		
		if(product == null) {
			throw new ExistenceException(" Product not found for this id: " + id);
		}
		
		product.relist();
		
		productRepository.update(product);
		
		return modelMapper.map(product, RelistProductCommandResponse.class);
	}
}