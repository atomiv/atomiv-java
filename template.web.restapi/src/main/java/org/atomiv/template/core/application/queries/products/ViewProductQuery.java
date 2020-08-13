package org.atomiv.template.core.application.queries.products;

import java.util.UUID;

import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class ViewProductQuery implements Command<ViewProductQueryResponse> {
	@Getter @Setter private UUID id;
}
