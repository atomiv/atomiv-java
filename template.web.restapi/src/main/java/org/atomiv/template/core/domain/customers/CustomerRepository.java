package org.atomiv.template.core.domain.customers;

import org.springframework.stereotype.Repository;


public interface CustomerRepository {
	void add(Customer customer);
	Customer find(CustomerIdentity id);
	void remove(CustomerIdentity id);
	void update(Customer customer);
}
