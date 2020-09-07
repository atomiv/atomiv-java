package org.atomiv.template.lite.web.restapi.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.atomiv.template.lite.web.restapi.exception.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();

	}

	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);

	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		return ResponseEntity.ok().body(customer);

	}

	/*
	 * Ova metoda uzima podatke iz baze u csv formatu kada se pokrene iz Postman -a
	 */
	@GetMapping("/customers/exportcsv")
	public void exportToCsv(HttpServletResponse response) throws Exception {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new java.util.Date());
		String fileName = "customer" + currentDateTime + ".csv";
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; fileNmae=" + fileName;

		response.setHeader(headerKey, headervalue);

		List<Customer> listCustomers = customerRepository.findAll();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "Customer ID", "First Name", "Last Name" };
		String[] nameMapping = { "id", "firstName", "lastName" };

		csvWriter.writeHeader(csvHeader);

		for (Customer customer : listCustomers) {
			csvWriter.write(customer, nameMapping);

		}
		csvWriter.close();

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") long customerId,
			@RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customerRepository.save(customer);
		return ResponseEntity.ok().body(customer);

	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") long customerId)
			throws ResourceNotFoundException {
		customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer not found for this id: " + customerId));
		customerRepository.deleteById(customerId);
		return ResponseEntity.ok().build();

	}

}
