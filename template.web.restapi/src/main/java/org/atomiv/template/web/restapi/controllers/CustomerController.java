package org.atomiv.template.web.restapi.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.atomiv.template.core.application.commands.customers.CreateCustomerCommand;
import org.atomiv.template.core.application.commands.customers.CreateCustomerCommandResponse;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommand;
import org.atomiv.template.core.application.commands.customers.DeleteCustomerCommandResponse;
import org.atomiv.template.core.application.commands.customers.EditCustomerCommand;
import org.atomiv.template.core.application.commands.customers.EditCustomerCommandResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQuery;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponseRecord;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQuery;
import org.atomiv.template.core.application.queries.customers.ViewCustomerQueryResponse;
import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.CustomerJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private Pipeline pipeline;
	
	// Commands
	
	@PostMapping
	public ResponseEntity<CreateCustomerCommandResponse> createCustomer(@Valid @RequestBody CreateCustomerCommand command) {
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<DeleteCustomerCommandResponse> deleteCustomer(@PathVariable(value = "id") UUID id)
			throws ResourceNotFoundException {
		var command = new DeleteCustomerCommand();
		command.setId(id);
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EditCustomerCommandResponse> editCustomer(@PathVariable(value = "id") UUID id,
			@RequestBody EditCustomerCommand command) throws ResourceNotFoundException {
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}
	
	
	// Queries
	
	@GetMapping
	public ResponseEntity<BrowseCustomersQueryResponse> browseCustomers(int page, int size) {
		var query = new BrowseCustomersQuery();
		query.setPage(page);
		query.setSize(size);
		var response = pipeline.send(query);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ViewCustomerQueryResponse> viewCustomer(@PathVariable(value = "id") UUID id)
			throws ResourceNotFoundException {
		var query = new ViewCustomerQuery();
		query.setId(id);
		var response = pipeline.send(query);
		return ResponseEntity.ok().body(response);
	}

}
