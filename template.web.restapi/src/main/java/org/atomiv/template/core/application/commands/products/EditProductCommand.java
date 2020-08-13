package org.atomiv.template.core.application.commands.products;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class EditProductCommand {
	@Getter @Setter private UUID id;
	@Getter @Setter private String description;
	@Getter @Setter private double unitPrice;
}
