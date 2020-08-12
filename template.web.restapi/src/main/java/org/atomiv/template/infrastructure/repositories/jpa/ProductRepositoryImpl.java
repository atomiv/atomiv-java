package org.atomiv.template.infrastructure.repositories.jpa;

import org.atomiv.template.core.domain.products.Product;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.atomiv.template.core.domain.products.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product find(ProductIdentity id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product find(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

}
