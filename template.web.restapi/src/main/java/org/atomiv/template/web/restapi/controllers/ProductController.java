package org.atomiv.template.web.restapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.atomiv.template.web.restapi.models.Product;
import org.atomiv.template.web.restapi.repositories.ProductRepository;
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
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		product.setIsListed(true);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping("/products/{id}/unlist")
	public ResponseEntity<Product> unlistProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setIsListed(false);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);

	}

	@PostMapping("/products/{id}/relist")
	public ResponseEntity<Product> relistProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setIsListed(true);
		productRepository.save(product);
		return ResponseEntity.ok().body(product);

	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		return ResponseEntity.ok().body(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long productId,
			@RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		product.setCode(productDetails.getCode());
		product.setDescription(productDetails.getDescription());
		product.setUnitPrice(productDetails.getUnitPrice());
		product.setIsListed(productDetails.getIsListed());
		productRepository.save(product);
		return ResponseEntity.ok().body(product);

	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id: " + productId));
		productRepository.deleteById(productId);
		return ResponseEntity.ok().build();

	}

}
