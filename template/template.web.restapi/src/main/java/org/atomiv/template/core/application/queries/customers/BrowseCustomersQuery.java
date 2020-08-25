package org.atomiv.template.core.application.queries.customers;

import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class BrowseCustomersQuery implements Command<BrowseCustomersQueryResponse> {
	@Getter @Setter private int page;
	@Getter @Setter private int size;
}
