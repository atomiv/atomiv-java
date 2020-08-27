package org.atomiv.template.core.application.commands.products;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class CreateProductCommand implements Command<CreateProductCommandResponse> {
	@Getter
	@Setter
	private String code;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private double unitPrice;
}
