package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.product.*;
import org.atomiv.template.lite.web.restapi.models.Product;
import org.atomiv.template.lite.web.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public GetAllProductsResponse getAllProducts() {

        var products = (List<Product>) productRepository.findAll();

        var records = new ArrayList<GetAllProductsRecordResponse>();

        for(Product product : products) {
            var record = new GetAllProductsRecordResponse();
            record.setId(product.getId());
            record.setName(product.getName());
            record.setLastModified(product.getLastModified());
            records.add(record);
        }

        var response = new GetAllProductsResponse();
        response.setRecords(records);

        return response;
    }



    @Override
    public GetProductResponse getProductById(long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);

//        if(optionalProduct.isEmpty()) {
//            throw new ProductNotFoundException("Product Not Found");
//        }

        var product = optionalProduct.get();

        var response = new GetProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setLastModified(product.getLastModified());

        return response;
    }




    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {

        // TODO. use mapper

        var product = new Product();
        product.setName(request.getName());
        product.setLastModified(LocalDateTime.now()); // TODO check
        productRepository.save(product);

        var response = new CreateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setLastModified(product.getLastModified());
        return response;
    }



    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {

        var id = request.getId();
        var optionalProduct = productRepository.findById(id);

//        if(optionalProduct.isEmpty()) {
//            throw new ProductNotFoundException("Product Not Found");
//        }

        var product = optionalProduct.get(); // Product product = optionalProduct.get() ??
        product.setName(request.getName());
        product.setLastModified(LocalDateTime.now());

        productRepository.save(product);

        var response = new UpdateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setLastModified(product.getLastModified());

        return response;
    }



    @Override
    public void deleteProductById(long id) {

        productRepository.deleteById(id);
    }


}
