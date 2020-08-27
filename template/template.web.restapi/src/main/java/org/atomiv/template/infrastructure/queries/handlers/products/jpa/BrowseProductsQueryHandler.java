package org.atomiv.template.infrastructure.queries.handlers.products.jpa;

import java.util.stream.Collectors;

import org.atomiv.template.core.application.queries.products.BrowseProductsQuery;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponseRecord;
import org.atomiv.template.infrastructure.persistence.jpa.records.ProductRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class BrowseProductsQueryHandler implements Command.Handler<BrowseProductsQuery, BrowseProductsQueryResponse> {

	@Autowired
	private ProductJpaRepository productJpaRepository;

	@Override
	public BrowseProductsQueryResponse handle(BrowseProductsQuery command) {
		var customerRecords = productJpaRepository.findAll();
		var responseRecords = customerRecords.stream().map(e -> getResponseRecord(e)).collect(Collectors.toList());

		var response = new BrowseProductsQueryResponse();
		response.setTotalRecords(responseRecords.size());
		response.setRecords(responseRecords);
		return response;
	}

	private BrowseProductsQueryResponseRecord getResponseRecord(ProductRecord productRecord) {
		var responseRecord = new BrowseProductsQueryResponseRecord();
		responseRecord.setId(productRecord.getId());
		responseRecord.setCode(productRecord.getCode());
		responseRecord.setDescription(productRecord.getDescription());
		responseRecord.setUnitPrice(productRecord.getUnitPrice());
		return responseRecord;
	}
}
