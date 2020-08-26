package org.atomiv.template.infrastructure.queries.handlers.customers.jpa;

import org.atomiv.template.core.application.queries.customers.BrowseCustomersQuery;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQuery;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQueryResponse;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class ViewCustomerQueryHandler implements Command.Handler<ViewCustomerQuery, ViewCustomerQueryResponse> {

	@Override
	public ViewCustomerQueryResponse handle(ViewCustomerQuery command) {
		
		/*
			CustomerRecord customer = customerRepository.findById(customerId)
					.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		*/

		
		// TODO Auto-generated method stub
		return null;
	}

}
