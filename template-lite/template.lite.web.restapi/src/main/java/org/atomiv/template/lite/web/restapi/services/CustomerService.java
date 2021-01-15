package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.customer.*;
import org.atomiv.template.lite.web.restapi.dtos.order_item.CreateOrderItemResponse;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerService {

    GetAllCustomersResponse getAllCustomers();

    GetCustomerResponse getCustomerById(long id);


    // List<Customer> findByFirstName(String firstName);

    // Long count();
    // long countAll = Customer.count();
    // long countActive = Customer.count("status", Status.Active)
//    @GET
//    public long count(){
//        return customerRepository.count();
//    }

//    long countActive = personRepository.count("status", Status.Active);

    // customerRepository.delete("status", Status.Active);

    // List<Customer> customers = Customer.list("order by name,birth");

    CreateCustomerResponse createCustomer(CreateCustomerRequest request);

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);

    void deleteCustomerById(long id);

    void deleteAllCustomers();

}
