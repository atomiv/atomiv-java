package org.atomiv.template.core.domain.products;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

	void add(Product product);

	Product find(ProductIdentity id);

	Product find(String code);

	void update(Product product);

}
