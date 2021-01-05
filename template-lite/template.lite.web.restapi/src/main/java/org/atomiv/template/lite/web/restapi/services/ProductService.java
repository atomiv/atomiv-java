package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.product.*;
import org.atomiv.template.lite.web.restapi.models.Product;

import java.util.List;

public interface ProductService {
//    List<Product> getAllProducts();
//
//    Product getProductById(long id);
//
//    Product createProduct(Product product);
//
//    Product updateProduct(Product product);
//
//    void deleteProductById(long id);


    GetAllProductsResponse getAllProducts();

    GetProductResponse getProductById(long id);

    CreateProductResponse createProduct(CreateProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);

    void deleteProductById(long id);




//    // TO DO pass in product id
//    Product findByOrderItemProductId(Long id);
}
