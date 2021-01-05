package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.dtos.product.*;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Product;
import org.atomiv.template.lite.web.restapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

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
        try {
            var response = productService.getProductById(id);
            return new ResponseEntity<GetProductResponse>(response, HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer Not Found");
        }
    }


    @PostMapping(path = "")
//    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product)
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request)
    {
        var response = productService.createProduct(request);
        return new ResponseEntity<CreateProductResponse>(response, HttpStatus.OK);
//                var newProduct = productService.createProduct(product);
//        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable(value = "id") Long id, @Valid @RequestBody UpdateProductRequest request)
    {
        var response = productService.updateProduct(request);
        return new ResponseEntity<UpdateProductResponse>(response, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
