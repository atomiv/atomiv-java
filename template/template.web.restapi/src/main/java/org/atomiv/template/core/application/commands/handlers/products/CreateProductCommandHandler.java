package org.atomiv.template.core.application.commands.handlers.products;

import java.util.UUID;

import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;
import org.atomiv.template.core.domain.products.Product;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.atomiv.template.core.domain.products.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Command;

public class CreateProductCommandHandler
		implements Command.Handler<CreateProductCommand, CreateProductCommandResponse> {

	private static boolean DEFAULT_IS_LISTED = true;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CreateProductCommandResponse handle(CreateProductCommand command) {

		// Some comment

		// TODO: VC: Handling default value
		var productId = new ProductIdentity(UUID.randomUUID());
		var code = command.getCode();
		var description = command.getDescription();
		var unitPrice = command.getUnitPrice();
		var isListed = DEFAULT_IS_LISTED;

		var product = new Product(productId, code, description, unitPrice, isListed);

		productRepository.add(product);

		return modelMapper.map(product, CreateProductCommandResponse.class);
	}
}
