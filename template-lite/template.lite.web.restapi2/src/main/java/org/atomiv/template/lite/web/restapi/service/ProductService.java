package org.atomiv.template.lite.web.restapi.service;

import java.util.List;

import org.atomiv.template.lite.web.restapi.models.Product;
import org.atomiv.template.lite.web.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product addOrupDate(Product product) {
		return productRepository.save(product);

	}

	public boolean deleteById(long id) {
		productRepository.deleteById(id);
		return true;

	}

	public List<Product> getAll() {
		return productRepository.findAll();

	}

	public Product getById(long id) {
		return productRepository.findById(id).get();

	}

}
