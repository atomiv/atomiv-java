package org.atomiv.template.infrastructure.queries.handlers.products.jpa;

import org.atomiv.framework.core.application.ExistenceException;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQueryResponse;
import org.atomiv.template.core.application.queries.products.BrowseProductsQuery;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;
import org.atomiv.template.core.application.queries.products.ViewProductQuery;
import org.atomiv.template.core.application.queries.products.ViewProductQueryResponse;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.records.ProductRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class ViewProductQueryHandler implements Command.Handler<ViewProductQuery, ViewProductQueryResponse> {

	@Autowired
	private ProductJpaRepository productJpaRepository;
	
	@Override
	public ViewProductQueryResponse handle(ViewProductQuery command) {
		var productRecordId = command.getId();
		var productRecord = productJpaRepository.findById(productRecordId);
		
		if(productRecord == null) {
			throw new ExistenceException(" Customer not found for this id: " + productRecordId);
		}
		
		return getResponseRecord(productRecord.get());
	}
	
	private ViewProductQueryResponse getResponseRecord(ProductRecord productRecord) {
		var responseRecord = new ViewProductQueryResponse();
		responseRecord.setId(productRecord.getId());
		responseRecord.setCode(productRecord.getCode());
		responseRecord.setDescription(productRecord.getDescription());
		responseRecord.setListed(productRecord.getIsListed());
		responseRecord.setUnitPrice(productRecord.getUnitPrice());
		return responseRecord;
	}
}
