package org.atomiv.template.core.application.queries.products;

import lombok.Getter;
import lombok.Setter;

public class BrowseProductsQuery {
	@Getter @Setter private int page;
	@Getter @Setter private int size;
}
