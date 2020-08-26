package org.atomiv.template.core.application.commands.customers;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class BrowseCustomersQueryResponse {
	@Getter @Setter List<BrowseCustomersQueryResponseRecord> records;
	@Getter @Setter long totalRecords;
}
