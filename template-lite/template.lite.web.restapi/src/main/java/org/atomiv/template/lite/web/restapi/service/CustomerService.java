package org.atomiv.template.lite.web.restapi.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.atomiv.template.lite.web.restapi.dto.CustomerDto;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	String line = "";

	public void saveCustomerData() throws FileNotFoundException {

		try {

			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Customer.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Customer c = new Customer();
				c.setFirstName(data[0]);
				c.setLastName(data[1]);
				customerRepository.save(c);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

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
