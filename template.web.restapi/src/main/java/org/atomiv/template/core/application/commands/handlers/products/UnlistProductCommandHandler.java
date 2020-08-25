package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.commands.products.RelistProductCommand;
import org.atomiv.template.core.application.commands.products.RelistProductCommandResponse;
import org.atomiv.template.core.application.commands.products.UnlistProductCommand;
import org.atomiv.template.core.application.commands.products.UnlistProductCommandResponse;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.atomiv.template.core.domain.products.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Command;

public class UnlistProductCommandHandler implements Command.Handler<UnlistProductCommand, UnlistProductCommandResponse> {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UnlistProductCommandResponse handle(UnlistProductCommand command) {
		var id = new ProductIdentity(command.getId());
		var product = productRepository.find(id);
		
		if(product == null) {
			throw new ExistenceException(" Product not found for this id: " + id);
		}
		
		product.unlist();
		
		productRepository.update(product);
		
		return modelMapper.map(product, UnlistProductCommandResponse.class);
	}

}
