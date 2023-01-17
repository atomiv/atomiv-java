package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomersControllerTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    void getAllCustomers() {
//        var customersFound = (List<Customer>) customerRepository.findAll();

//        assertNotNull(customersFound);
//        assertEquals(3, customersFound.size());
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void createCustomer() {
        Customer testClass = new Customer();

        testClass.setFirstName("Jane");
        assertEquals("Jane", testClass.getFirstName());

        testClass.setLastName("Lewis");
        assertEquals("Lewis", testClass.getLastName());
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void deleteAllCustomers() {
    }
}