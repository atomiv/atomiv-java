package org.atomiv.template.core.application.commands.products;

import lombok.Getter;
import lombok.Setter;

public class CreateProductCommand {
	@Getter @Setter private String code;
	@Getter @Setter private String description;
	@Getter @Setter private double unitPrice;
}
