package org.atomiv.template.core.application.commands.products;

import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class EditProductCommand implements Command<EditProductCommandResponse> {
	@Getter
	@Setter
	private UUID id;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private double unitPrice;
}
