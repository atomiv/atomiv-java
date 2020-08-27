package org.atomiv.template.infrastructure.repositories.jpa;

import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.customers.CustomerRepository;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.CustomerJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private CustomerJpaRepository customerJpaRepository;

	public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository) {
		this.customerJpaRepository = customerJpaRepository;
	}

	@Override
	public void add(Customer customer) {
		var customerRecord = getCustomerRecord(customer);
		customerJpaRepository.save(customerRecord);
	}

	@Override
	public Customer find(CustomerIdentity id) {
		var customerRecordId = id.getValue();
		var customerRecord = customerJpaRepository.findById(customerRecordId);

		if (customerRecord.isEmpty()) {
			return null;
		}

		return getCustomer(customerRecord.get());
	}

	@Override
	public void remove(CustomerIdentity id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Customer customer) {
		var customerRecordId = customer.getId().getValue();
		var customerRecord = customerJpaRepository.findById(customerRecordId).get();

		customerRecord.setFirstName(customer.getFirstName());
		customerRecord.setLastName(customer.getLastName());

		customerJpaRepository.save(customerRecord);
	}

	@Override
	public boolean exists(CustomerIdentity id) {
		// TODO Auto-generated method stub
		return false;
	}

	private CustomerRecord getCustomerRecord(Customer customer) {
		var id = customer.getId().getValue();
		var firstName = customer.getFirstName();
		var lastName = customer.getLastName();

		return new CustomerRecord(id, firstName, lastName);
	}

	private Customer getCustomer(CustomerRecord customerRecord) {
		var id = new CustomerIdentity(customerRecord.getId());
		var firstName = customerRecord.getFirstName();
		var lastName = customerRecord.getLastName();
		return new Customer(id, firstName, lastName);
	}
}
