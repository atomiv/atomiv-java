package org.atomiv.template.lite.web.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.atomiv.template.lite.web.restapi.dto.CustomerDto;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDtoServiceImpl implements CustomerDtoService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerDto> getAllCustomers() {

		List<CustomerDto> list = new ArrayList<>();

		List<Customer> customers = this.customerRepository.findAll();

		for (Customer cus : customers) {
			list.add(new CustomerDto(cus.getId(), cus.getFirstName(), cus.getLastName()));

		}

		return list;

	}

//	public Optional<CustomerDto> getCustomerById(long customerId) {
//		Optional<Customer> customer = this.customerRepository.findById(customerId);
//		Customer cus = customer.get();
//		return Optional.of(new CustomerDto(cus.getId(), cus.getFirstName(), cus.getLastName()));
//	}
//
//	@Override
//	public Customer createCustomer(CustomerDto customer) {
//		return this.customerRepository
//				.save(new Customer(customer.getFirstName(), customer.getLastName()));
//	}

	@Override
	public Customer updateCustomer(Customer customerDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public Optional<CustomerDto> getCustomersById(long customerId) {
//		java.util.Optional<Customer> customer = this.customerRepository.findById(customerId);
//		Customer cus = customer.get();
//		return Optional.of(new CustomerDto(cus.getId(), cus.getFirstName(), cus.getLastName()));
//		
//	}
//
//	@Override
//	public Optional<Customer> getCustomerId(long customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Customer createCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CustomerDto> getCustomersById(long customerId) {
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		Customer cus = customer.get();
		return Optional.of(new CustomerDto(cus.getId(), cus.getFirstName(), cus.getLastName()));
	}

	@Override
	public Optional<Customer> getCustomerId(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
