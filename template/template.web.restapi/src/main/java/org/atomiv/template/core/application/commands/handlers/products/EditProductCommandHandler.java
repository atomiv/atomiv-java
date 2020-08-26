package org.atomiv.template.core.application.commands.handlers.products;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;
import org.atomiv.template.core.application.commands.products.EditProductCommand;
import org.atomiv.template.core.application.commands.products.EditProductCommandResponse;
import org.atomiv.template.core.domain.products.Product;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.atomiv.template.core.domain.products.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import an.awesome.pipelinr.Command;

public class EditProductCommandHandler implements Command.Handler<EditProductCommand, EditProductCommandResponse> {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EditProductCommandResponse handle(EditProductCommand command) {
		var id = new ProductIdentity(command.getId());
		var product = productRepository.find(id);
		
		if(product == null) {
			throw new ExistenceException(" Product not found for this id: " + id);
		}
		
		Update(product, command);
		productRepository.update(product);
		
		return modelMapper.map(product, EditProductCommandResponse.class);
	}
	
	private void Update(Product product, EditProductCommand command) {
		var description = command.getDescription();
		var unitPrice = command.getUnitPrice();
		
		product.setDescription(description);
		product.setUnitPrice(unitPrice);
	}

}
