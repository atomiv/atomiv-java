package org.atomiv.template.core.application.commands.customers;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class BrowseCustomersQueryResponseRecord {
	@Getter @Setter private UUID id;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
}
