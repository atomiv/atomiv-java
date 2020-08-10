package org.atomiv.template.web.restapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.atomiv.template.infrastructure.persistence.jpa.CustomerRecord;
import org.atomiv.template.infrastructure.repositories.jpa.CustomerRepository;
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

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public ResponseEntity<List<CustomerRecord>> getAllCustomers() {
		var customers = customerRepository.findAll();
		return ResponseEntity.ok().body(customers);
	}

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

}
