package org.atomiv.template.core.application.queries.products;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class BrowseProductsQueryResponse {
	@Getter
	@Setter
	List<BrowseProductsQueryResponseRecord> records;
	@Getter
	@Setter
	long totalRecords;
}
