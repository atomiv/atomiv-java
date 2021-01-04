package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.CreateProductRequest;
import org.atomiv.template.lite.web.restapi.dtos.CreateProductResponse;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.atomiv.template.lite.web.restapi.models.Product;
import org.atomiv.template.lite.web.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Service
//public class ProductServiceImpl implements ProductService {
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent())
            return optionalProduct.get();
        else
            throw new CustomerNotFoundException("Customer Not Found");
    }

    @Override
//    public Product createProduct(Product product) {
    public CreateProductResponse createProduct(CreateProductRequest request) {

        var product = new Product();
        product.setName(request.getName());
        productRepository.save(product);
//        return productRepository.save(product);
        var response = new CreateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }

    @Override
    public Product updateProduct(Product product) {
        product.setName(product.getName());
        return productRepository.save(product);
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
