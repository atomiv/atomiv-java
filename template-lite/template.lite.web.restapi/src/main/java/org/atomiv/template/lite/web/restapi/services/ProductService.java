package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.CreateProductRequest;
import org.atomiv.template.lite.web.restapi.dtos.CreateProductResponse;
import org.atomiv.template.lite.web.restapi.models.OrderItem;
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


    List<Product> getAllProducts();

    Product getProductById(long id);

    CreateProductResponse createProduct(CreateProductRequest request);

    Product updateProduct(Product product);

    void deleteProductById(long id);




//    // TO DO pass in product id
//    Product findByOrderItemProductId(Long id);
}
