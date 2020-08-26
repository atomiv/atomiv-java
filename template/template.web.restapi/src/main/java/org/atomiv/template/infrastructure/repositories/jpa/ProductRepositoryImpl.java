package org.atomiv.template.infrastructure.repositories.jpa;

import org.atomiv.template.core.domain.customers.Customer;
import org.atomiv.template.core.domain.products.Product;
import org.atomiv.template.core.domain.products.ProductIdentity;
import org.atomiv.template.core.domain.products.ProductRepository;
import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.atomiv.template.infrastructure.persistence.jpa.records.ProductRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.CustomerJpaRepository;
import org.atomiv.template.infrastructure.persistence.jpa.repos.ProductJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private ProductJpaRepository productJpaRepository;
	
	public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
		this.productJpaRepository = productJpaRepository;
	}
	
	@Override
	public void add(Product product) {
		var productRecord = getProductRecord(product);
		productJpaRepository.save(productRecord);
	}

	@Override
	public Product find(ProductIdentity id) {
		var productRecordId = id.getValue();
		var productRecord = productJpaRepository.findById(productRecordId);
		
		if(productRecord.isEmpty()) {
			return null;
		}
		
		return getProduct(productRecord.get());
	}

	@Override
	public Product find(String code) {
		var productRecord = productJpaRepository.findFirstByCode(code);

		if(productRecord.isEmpty()) {
			return null;
		}
		
		return getProduct(productRecord.get());
	}

	@Override
	public void update(Product product) {
		var productRecordId = product.getId().getValue();
		var productRecord = productJpaRepository.findById(productRecordId).get();
		
		productRecord.setCode(product.getCode());
		productRecord.setDescription(product.getDescription());
		productRecord.setUnitPrice(product.getUnitPrice());
		productRecord.setIsListed(product.getIsListed());
		
		productJpaRepository.save(productRecord);
	}

	private ProductRecord getProductRecord(Product product) {
		var id = product.getId().getValue();
		var code = product.getCode();
		var description = product.getDescription();
		var unitPrice = product.getUnitPrice();
		var isListed = product.getIsListed();
		
		return new ProductRecord(id, code, description, unitPrice, isListed);
	}
	
	private Product getProduct(ProductRecord productRecord) {
		var id = new ProductIdentity(productRecord.getId());
		var code = productRecord.getCode();
		var description = productRecord.getDescription();
		var unitPrice = productRecord.getUnitPrice();
		var isListed = productRecord.getIsListed();
		
		return new Product(id, code, description, unitPrice, isListed);
	}
}
