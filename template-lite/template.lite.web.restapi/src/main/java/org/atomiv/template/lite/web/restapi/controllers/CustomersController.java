package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.dtos.customer.*;
import org.atomiv.template.lite.web.restapi.dtos.product.GetProductResponse;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.atomiv.template.lite.web.restapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Customer Controller
 */
@RestController
@RequestMapping("api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;


    /**
     * Get all customers list
     * @return the list
     */
    @GetMapping(path = "")
    public ResponseEntity<GetAllCustomersResponse> getAllCustomers()
    {
        var response = customerService.getAllCustomers();
        return new ResponseEntity<GetAllCustomersResponse>(response,HttpStatus.OK);
    }



//     * @throws ResourceNotFoundException the resource not found exception
    /**
     * Get customer by id
     *
     * @param id the customer id
     * @return the customer by id
     */
    @GetMapping("{id}")
    public ResponseEntity<GetCustomerResponse> getCustomerById(@PathVariable("id") long id)
    {
        var response = customerService.getCustomerById(id);

        if(response == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return new ResponseEntity<GetCustomerResponse>(response, HttpStatus.OK);
    }


    /**
     * Create customer
     *
     * @param request the customer request
     * @return the customer
     */
    @PostMapping(path = "")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request)
    {
        var response= customerService.createCustomer(request);
        return new ResponseEntity<CreateCustomerResponse>(response, HttpStatus.OK);
    }


//     * @throws ResourceNotFoundException the resource not found exception
    /**
     * Update the customer response entity
     * @param id the customer id
     * @param request the customer details
     * @return the response entity
     */
    @PutMapping("{id}")
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@PathVariable(value = "id") long id, @Valid @RequestBody UpdateCustomerRequest request)
        {
            try {
                var response = customerService.updateCustomer(request);
                return new ResponseEntity<UpdateCustomerResponse>(response, HttpStatus.OK);
            } catch(Exception ex) {
                throw ex;
            }


        }



    /**
     * Delete customer // delete customer map
     * @param id the customer id
     * @return the map
     * @throws ResourceNotFoundException the resource not found
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);

        // TODO Java Rest API return No Content
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//        if(customer==null)
//            throw new CustomerNotFoundException("id: " + id);
    }



    @DeleteMapping("")
    public void deleteAllCustomers() {

        customerService.deleteAllCustomers();
    }


}











