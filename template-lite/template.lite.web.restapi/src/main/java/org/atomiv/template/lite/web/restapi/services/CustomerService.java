package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CustomerService or ICustomerService
public interface CustomerService {

    // getCustomers listCustomers getAllCustomers
    List<Customer> getAllCustomers();

    // findCustomer getCustomer getCustomerById
    Customer getCustomerById(long id);

    List<Customer> findByFirstName(String firstName);

    // guess - POST
    Customer createCustomer(Customer customer);

    // guess - UPDATE
    Customer updateCustomer(Customer customer);

    // void deleteById(String id);
    // guess - DELETE
    void deleteCustomerById(long id);

    void deleteAllCustomers();

}
