package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.dtos.customer.*;
import org.atomiv.template.lite.web.restapi.exceptions.working.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


// not necessary
//        if(response == null) {
////            throw new CustomerNotFoundException("Customer not found");
//            throw new ResourceNotFoundException("Customer not found with id :" + id);
//        }

        return new ResponseEntity<GetCustomerResponse>(response, HttpStatus.OK);

        //return this.userRepository.findById(userId)
        //				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

//    @GetMapping("/getCustomer/{name}")
//    public ResponseEntity<GetCustomerResponse> getCustomerByName(@PathVariable("name") String name)
//    {
//        var response = customerService.getCustomerByName(name);
//
//        if(response == null) {
////            throw new CustomerNotFoundException("Customer not found");
//    throw new ServiceException("Employee Not Found : " + firstName, HttpStatus.CONFLICT.value());
//        }
//
//        return new ResponseEntity<GetCustomerResponse>(response, HttpStatus.OK);
//    }


    /**
     * Create customer
     *
     * @param request the customer request
     * @return the customer
     */
    @PostMapping(path = "")
    //customerRequest request) throws ServiceException2 {
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request)
    {
        var response= customerService.createCustomer(request);
        return new ResponseEntity<CreateCustomerResponse>(response, HttpStatus.OK);

//        if (employee.getName() == null || employee.getName().isEmpty()) {
//			throw new ServiceException("Name should not be empty or null", HttpStatus.BAD_REQUEST.value());
//
//		} else {
//			return dao.save(employee);
//		}
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











