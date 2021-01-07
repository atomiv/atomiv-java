package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.dtos.product.*;
import org.atomiv.template.lite.web.restapi.exceptions.ProductNotFoundException;
import org.atomiv.template.lite.web.restapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    ProductService productService;


    @GetMapping(path = "")
    public ResponseEntity<GetAllProductsResponse> getAllProducts()
    {
        var response = productService.getAllProducts();
        return new ResponseEntity<GetAllProductsResponse>(response, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<GetProductResponse> getProductById(@PathVariable("id") Long id)
    {
        var response = productService.getProductById(id);

        // TODO error handling - CHECK
        // TODO Postman error message - customize
        if(response == null) {
            throw new ProductNotFoundException("Product Not Found");
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
            // System.out.println("Product doesn't exist " + product.getId());
            // System.out.println(product);
        }

        return new ResponseEntity<GetProductResponse>(response, HttpStatus.OK);
    }


    @PostMapping(path = "")
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request)
    {
        var response = productService.createProduct(request);
        return new ResponseEntity<CreateProductResponse>(response, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable(value = "id") Long id, @Valid @RequestBody UpdateProductRequest request)
    {
        var response = productService.updateProduct(request);
        return new ResponseEntity<UpdateProductResponse>(response, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProductById(id);
    }
}


// TODO - error handling for Post, Put, Delete?
