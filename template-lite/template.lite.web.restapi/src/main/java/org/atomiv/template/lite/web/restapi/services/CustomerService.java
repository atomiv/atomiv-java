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

    CreateCustomerResponse createCustomer(CreateCustomerRequest request);

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);

    void deleteCustomerById(long id);

    void deleteAllCustomers();

}
