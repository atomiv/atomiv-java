package org.atomiv.template.core.application.queries.customers;

import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class ViewCustomerQuery implements Command<ViewCustomerQueryResponse>{
	@Getter @Setter private UUID id;
}
