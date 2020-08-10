package org.atomiv.template.web.restapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.atomiv.template.web.restapi.models.Customer;
import org.atomiv.template.web.restapi.repositories.CustomerRepository;
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
	public ResponseEntity<List<Customer>> getAllCustomers() {
		var customers = customerRepository.findAll();
		return ResponseEntity.ok().body(customers);
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		customerRepository.save(customer);
		return ResponseEntity.ok().body(customer);
	}

	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		return ResponseEntity.ok().body(customer);
	}

	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") long customerId,
			@RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
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
