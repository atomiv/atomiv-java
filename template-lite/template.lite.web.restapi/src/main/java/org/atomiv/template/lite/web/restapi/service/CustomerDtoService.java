package org.atomiv.template.lite.web.restapi.service;

import java.util.List;
import java.util.Optional;

import org.atomiv.template.lite.web.restapi.dto.CustomerDto;
import org.atomiv.template.lite.web.restapi.models.Customer;

// TODO: CustomerService

public interface CustomerDtoService {

	List<CustomerDto> getAllCustomers();

	Optional<CustomerDto> getCustomersById(long customerId);

	Optional<Customer> getCustomerId(long customerId);

	Customer createCustomer(CustomerDto customer);

	Customer updateCustomer(Customer customerDetails);

	void deleteCustomer(Customer customer);

}
