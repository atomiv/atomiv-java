package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.product.*;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Product;
import org.atomiv.template.lite.web.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
//public class ProductServiceImpl implements ProductService {
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;



    @Override
    public GetAllProductsResponse getAllProducts() {
        var products = (List<Product>) productRepository.findAll();

        var records = new ArrayList<GetAllProductsRecordResponse>();

        for(Product product: products) {
            var record = new GetAllProductsRecordResponse();
            record.setId(product.getId());
            record.setName(product.getName());
            records.add(record);
        }

        var response = new GetAllProductsResponse();
        response.setRecords(records);
        return response;
    }



    @Override
    public GetProductResponse getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()) {
            throw new CustomerNotFoundException("Customer Not Found");
        }

        var product = optionalProduct.get();

        var response = new GetProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());

        return response;

        /*

        if(optionalProduct.isPresent()) {
            var product = optionalProduct.get();

            var response = new GetProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());

            return response;
        } else {
            throw new CustomerNotFoundException("Customer Not Found");
        }

         */

//        Optional<Product> optionalProduct = productRepository.findById(id);
//
//        if(optionalProduct.isPresent())
//            return optionalProduct.get();
//        else
//            throw new CustomerNotFoundException("Customer Not Found");
    }




    @Override
//    public Product createProduct(Product product) {
    public CreateProductResponse createProduct(CreateProductRequest request) {

        // TODO. using mapper

        var product = new Product();
        product.setName(request.getName());
        productRepository.save(product);

        var response = new CreateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }




    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        var id = request.getId();
        var optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()) {
//            throw new ProductNotExistExcption();
        }

        var product = optionalProduct.get();
        product.setName(request.getName());
//        product.setLastModified(System.now());

        productRepository.save(product);

        var response = new UpdateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
//        response.setLastModified(product.getLastModified());

        return response;
    }




    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }



//-------------------------------------------------
    //@Override
    //public DepartmentEntity getDepartmentById(Integer id) {
    //    return manager.find(DepartmentEntity.class, id);
    //}

    // Using EntityManager em;
    //public User getUserById(Long id) {
    //        return em.getReference(User.class, id);
    //    }


//    @Override
//    public Product findByOrderItemProductId(Long id) {
//        //Product product = productRepository.findByOrderItemProductId(orderItem);
//
//        // added dependency: <artifactId>hibernate-entitymanager</artifactId>
//        //return manager.find(DepartmentEntity.class, id);
//
//        //Query query = session.createQuery("from User u where u.email = :email ");
//        //query.setParameter("email", email);
//        //List list = query.list();
//
//
//        return null;
//        //
//        //use the inherited findOne(..) method to get the existing persistent instance.
//    }

}
