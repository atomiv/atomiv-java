package org.atomiv.template.core.application.commands.customers;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class BrowseCustomersQuery implements Command<BrowseCustomersQueryResponse> {
	@Getter @Setter private int page;
	@Getter @Setter private int size;
}
