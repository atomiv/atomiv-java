package org.atomiv.template.core.application.queries.customers;

import lombok.Getter;
import lombok.Setter;

public class BrowseCustomersQuery {
	@Getter @Setter private int page;
	@Getter @Setter private int size;
}
