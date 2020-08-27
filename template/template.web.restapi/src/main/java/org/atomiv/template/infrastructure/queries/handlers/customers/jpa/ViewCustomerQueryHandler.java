package org.atomiv.template.infrastructure.queries.handlers.customers.jpa;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQuery;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQueryResponse;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class ViewCustomerQueryHandler implements Command.Handler<ViewCustomerQuery, ViewCustomerQueryResponse> {

	@Autowired
	private CustomerJpaRepository customerJpaRepository;

	@Override
	public ViewCustomerQueryResponse handle(ViewCustomerQuery command) {
		var customerRecordId = command.getId();
		var customerRecord = customerJpaRepository.findById(customerRecordId);

		if (customerRecord == null) {
			throw new ExistenceException(" Customer not found for this id: " + customerRecordId);
		}

		return getResponseRecord(customerRecord.get());
	}

	private ViewCustomerQueryResponse getResponseRecord(CustomerRecord customerRecord) {
		var responseRecord = new ViewCustomerQueryResponse();
		responseRecord.setId(customerRecord.getId());
		responseRecord.setFirstName(customerRecord.getFirstName());
		responseRecord.setLastName(customerRecord.getLastName());
		return responseRecord;
	}

}
