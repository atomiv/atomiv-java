package org.atomiv.template.infrastructure.persistence.jpa;

import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.customers.CustomerIdentity;
import org.atomiv.template.core.domain.products.Product;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

	void add(Product product);
	Product find(ProductIdentity id);
	Product find(String productCode);
	void update(Product product);
	
}
