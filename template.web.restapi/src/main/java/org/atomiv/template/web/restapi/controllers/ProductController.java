package org.atomiv.template.web.restapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.atomiv.template.infrastructure.persistence.jpa.records.ProductRecord;
import org.atomiv.template.infrastructure.persistence.jpa.repos.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	/*
	
	@Autowired
	private ProductJpaRepository productRepository;

	@GetMapping
	public ResponseEntity<List<ProductRecord>> getAllProducts() {
		var products = productRepository.findAll(); 
		return ResponseEntity.ok().body(products);
	}

	@PostMapping
	public ResponseEntity<ProductRecord> createProduct(@Valid @RequestBody ProductRecord product) {
		product.setIsListed(true);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping("{id}/unlist")
	public ResponseEntity<ProductRecord> unlistProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setIsListed(false);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);

	}

	@PostMapping("{id}/relist")
	public ResponseEntity<ProductRecord> relistProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setIsListed(true);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);

	}

	@GetMapping("{id}")
	public ResponseEntity<ProductRecord> getProductById(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		return ResponseEntity.ok().body(product);
	}

	@PutMapping("{id}")
	public ResponseEntity<ProductRecord> updateProduct(@PathVariable(value = "id") long productId,
			@RequestBody ProductRecord productDetails) throws ResourceNotFoundException {
		ProductRecord product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setCode(productDetails.getCode());
		product.setDescription(productDetails.getDescription());
		product.setUnitPrice(productDetails.getUnitPrice());
		product.setIsListed(productDetails.getIsListed());
		productRepository.save(product);
		return ResponseEntity.ok().body(product);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		productRepository.deleteById(productId);
		return ResponseEntity.ok().build();
	}

	*/
}
