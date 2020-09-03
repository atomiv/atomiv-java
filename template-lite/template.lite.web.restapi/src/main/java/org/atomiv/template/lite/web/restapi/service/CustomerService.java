package org.atomiv.template.lite.web.restapi.service;

import java.util.List;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addOrupDate(Customer customer) {
		return customerRepository.save(customer);

	}

	public boolean deleteById(long id) {
		customerRepository.deleteById(id);
		return true;

	}

	public List<Customer> listAll() {
		return customerRepository.findAll(Sort.by("firstName").ascending());

	}

	public Customer getById(long id) {
		return customerRepository.findById(id).get();

	}

}
