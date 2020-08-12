package org.atomiv.template.infrastructure.repositories.jpa;

import java.util.List;

import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.CustomerJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	private CustomerJpaRepository jpaRepository;
	
	public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public void add(Customer customer) {
		var customerRecord = getCustomerRecord(customer);
		jpaRepository.save(customerRecord);
	}

	@Override
	public Customer find(CustomerIdentity id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(CustomerIdentity id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	
	private CustomerRecord getCustomerRecord(Customer customer) {
		
		var id = customer.getId().getValue();
		var firstName = customer.getFirstName();
		var lastName = customer.getLastName();
		
		return new CustomerRecord(id, firstName, lastName);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
