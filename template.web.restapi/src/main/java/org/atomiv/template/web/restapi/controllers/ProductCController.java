package org.atomiv.template.web.restapi.controllers;

import java.util.List;

import org.atomiv.template.web.restapi.models.Product;
import org.atomiv.template.web.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductCController {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
		
		
	}

}
