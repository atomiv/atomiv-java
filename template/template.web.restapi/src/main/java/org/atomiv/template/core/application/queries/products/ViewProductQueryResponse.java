package org.atomiv.template.core.application.queries.products;

import lombok.Getter;
import lombok.Setter;

public class ViewProductQueryResponse {
	@Getter @Setter private String code;
	@Getter @Setter private String description;
	@Getter @Setter private double unitPrice;
	@Getter @Setter private boolean isListed;
}
