package org.atomiv.template.core.application.queries.products;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class BrowseProductsQuery implements Command<BrowseProductsQueryResponse> {
	@Getter
	@Setter
	private int page;
	@Getter
	@Setter
	private int size;
}
