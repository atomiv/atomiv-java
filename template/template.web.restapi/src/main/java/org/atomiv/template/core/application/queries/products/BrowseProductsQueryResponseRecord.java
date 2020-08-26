package org.atomiv.template.core.application.queries.products;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class BrowseProductsQueryResponseRecord {
	@Getter @Setter private UUID id;
	@Getter @Setter private String code;
	@Getter @Setter private String description;
	@Getter @Setter private double unitPrice;
}
