package org.atomiv.template.core.domain.customers;

public interface CustomerRepository {
	void add(Customer customer);

	Customer find(CustomerIdentity id);

	void remove(CustomerIdentity id);

	void update(Customer customer);

	boolean exists(CustomerIdentity id);
}
