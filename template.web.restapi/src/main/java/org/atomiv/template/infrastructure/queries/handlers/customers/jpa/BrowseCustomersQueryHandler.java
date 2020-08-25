package org.atomiv.template.infrastructure.queries.handlers.customers.jpa;

import java.util.stream.Collectors;

import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQuery;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponseRecord;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Command;

public class BrowseCustomersQueryHandler implements Command.Handler<BrowseCustomersQuery, BrowseCustomersQueryResponse> {

	@Autowired
	private CustomerJpaRepository customerJpaRepository;
	
	@Override
	public BrowseCustomersQueryResponse handle(BrowseCustomersQuery command) {
		var customerRecords = customerJpaRepository.findAll();
		
		var responseRecords = customerRecords
				.stream()
				.map(e -> getResponseRecord(e))
				.collect(Collectors.toList());
		
		var response = new BrowseCustomersQueryResponse();
		response.setTotalRecords(responseRecords.size());
		response.setRecords(responseRecords);
		return response;
	}
	
	private BrowseCustomersQueryResponseRecord getResponseRecord(CustomerRecord customerRecord) {
		var responseRecord = new BrowseCustomersQueryResponseRecord();
		responseRecord.setId(customerRecord.getId());
		responseRecord.setFirstName(customerRecord.getFirstName());
		responseRecord.setLastName(customerRecord.getLastName());
		return responseRecord;
	}

}
