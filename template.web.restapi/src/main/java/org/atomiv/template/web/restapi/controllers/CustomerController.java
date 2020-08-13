package org.atomiv.template.web.restapi.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.atomiv.template.core.application.commands.customers.CreateCustomerCommand;
import org.atomiv.template.core.application.commands.customers.CreateCustomerCommandResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponse;
import org.atomiv.template.core.application.queries.customers.BrowseCustomersQueryResponseRecord;
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
	
	@PostMapping
	public ResponseEntity<CreateCustomerCommandResponse> createCustomer(@Valid @RequestBody CreateCustomerCommand command) {
		
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}
	
	// TODO: VC: Request should include 
	
	@GetMapping
	public ResponseEntity<BrowseCustomersQueryResponse> browseCustomers(int page, int size) {
		
		var response = new BrowseCustomersQueryResponse();
		
		return ResponseEntity.ok().body(response);
		
		
		/*
		var customers = customerRepository.findAll();
		
		var responseRecords = modelMapper.map(customers, new TypeToken<List<BrowseCustomersQueryResponseRecord>>() {}.getType());
		
		var response
		
		return ResponseEntity.ok().body(customers);
		*/
	}

	
	/*




	@PostMapping
	public ResponseEntity<CustomerRecord> createCustomer(@Valid @RequestBody CustomerRecord customer) {
		customerRepository.save(customer);
		return ResponseEntity.ok().body(customer);
	}

	@GetMapping("{id}")
	public ResponseEntity<CustomerRecord> getCustomerById(@PathVariable(value = "id") long customerId)
			throws ResourceNotFoundException {
		CustomerRecord customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		return ResponseEntity.ok().body(customer);
	}

	@PutMapping("{id}")
	public ResponseEntity<CustomerRecord> updateCustomer(@PathVariable(value = "id") long customerId,
			@RequestBody CustomerRecord customerDetails) throws ResourceNotFoundException {
		CustomerRecord customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customerRepository.save(customer);
		return ResponseEntity.ok().body(customer);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") long customerId)
			throws ResourceNotFoundException {
		customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		customerRepository.deleteById(customerId);
		return ResponseEntity.ok().build();

	}
	
	*/

}
