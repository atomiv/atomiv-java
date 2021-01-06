package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.product.*;

public interface ProductService {

    GetAllProductsResponse getAllProducts();

    GetProductResponse getProductById(long id);

    CreateProductResponse createProduct(CreateProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);

    void deleteProductById(long id);
}
