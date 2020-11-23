package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerService {

    // GET
    List<Customer> getAllCustomers();

    // GET id
    Customer getCustomerById(long id);

    //
    List<Customer> findByFirstName(String firstName);

    // POST
    Customer createCustomer(Customer customer);

    // UPDATE
    Customer updateCustomer(Customer customer);

    // DELETE
    void deleteCustomerById(long id);

    void deleteAllCustomers();

}
