package org.atomiv.template.web.restapi.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.atomiv.template.core.application.commands.products.CreateProductCommand;
import org.atomiv.template.core.application.commands.products.CreateProductCommandResponse;
import org.atomiv.template.core.application.commands.products.EditProductCommand;
import org.atomiv.template.core.application.commands.products.EditProductCommandResponse;
import org.atomiv.template.core.application.commands.products.RelistProductCommand;
import org.atomiv.template.core.application.commands.products.RelistProductCommandResponse;
import org.atomiv.template.core.application.commands.products.UnlistProductCommand;
import org.atomiv.template.core.application.commands.products.UnlistProductCommandResponse;
import org.atomiv.template.core.application.queries.products.BrowseProductsQuery;
import org.atomiv.template.core.application.queries.products.BrowseProductsQueryResponse;
import org.atomiv.template.core.application.queries.products.ViewProductQuery;
import org.atomiv.template.core.application.queries.products.ViewProductQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private Pipeline pipeline;

	// Commands

	@PostMapping
	public ResponseEntity<CreateProductCommandResponse> createProduct(
			@Valid @RequestBody CreateProductCommand command) {
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}

	@PutMapping("{id}")
	public ResponseEntity<EditProductCommandResponse> editProduct(@PathVariable(value = "id") UUID id,
			@RequestBody EditProductCommand command) throws ResourceNotFoundException {
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("{id}/relist")
	public ResponseEntity<RelistProductCommandResponse> relistProduct(@PathVariable(value = "id") UUID id)
			throws ResourceNotFoundException {
		var command = new RelistProductCommand();
		command.setId(id);
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("{id}/unlist")
	public ResponseEntity<UnlistProductCommandResponse> unlistProduct(@PathVariable(value = "id") UUID id)
			throws ResourceNotFoundException {
		var command = new UnlistProductCommand();
		command.setId(id);
		var response = pipeline.send(command);
		return ResponseEntity.ok().body(response);
	}

	// Queries

	@GetMapping
	public ResponseEntity<BrowseProductsQueryResponse> browseProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		var query = new BrowseProductsQuery();
		query.setPage(page);
		query.setSize(size);
		var response = pipeline.send(query);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<ViewProductQueryResponse> viewProduct(@PathVariable(value = "id") UUID id)
			throws ResourceNotFoundException {
		var query = new ViewProductQuery();
		query.setId(id);
		var response = pipeline.send(query);
		return ResponseEntity.ok().body(response);
	}
}
