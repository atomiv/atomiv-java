package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.dtos.customer.*;
import org.atomiv.template.lite.web.restapi.exceptions.ValidationException;
import org.atomiv.template.lite.web.restapi.exceptions.remove.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.remove.TaskNotFoundException;
import org.atomiv.template.lite.web.restapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Customer Controller
 */
@RestController
//@Validated
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
    // @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces =
    //    "application/json")
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
    // TODO Errors --> Impl
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request, Errors errors) throws ValidationException
    {
        /*
        int [] intArray = {1, 3, 5, 7, 9};
    for(int currentValue : intArray) {
      System.out.println(currentValue);
    }


    String myString = "hello";

    for(char c : myString.toCharArray()) {
      System.out.print(c);
    }




String [] myStrings  = {
      "alpha",
      "beta",
      "gamma",
      "delta"
    };

    for(String currentString : myStrings) {
      System.out.println(currentString);
    }



    List<String> myList = new ArrayList<String>();
    myList.add("alpha");
    myList.add("beta");
    myList.add("gamma");
    myList.add("delta");

    for(String currentItem : myList) {
      System.out.println(currentItem);
    }

    https://funnelgarden.com/java-for-loop/



         */





        // if (result.hasErrors()) {
        // debug
        if (errors.hasErrors()) {
            var allErrors = errors.getAllErrors();

            var myMessage = new ArrayList<String>();
            StringBuffer text = new StringBuffer();

            for (ObjectError error : allErrors) {
                var customMessage2 = error.getDefaultMessage() + '\n' + "\r\n" + System.lineSeparator() + "<br>" + "---";
                var apple = text.append(customMessage2.toString()).append('\n');
                myMessage.add(apple.toString());

//                System.out.println("Hello" + '\n' + "World");
            }
//            return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
//            throw new ValidationException("Some fields are null or empty---");
//            throw new ValidationException(pear);
//            String customMessage2;
            throw new ValidationException(myMessage.toString());


        }

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
    // BindingResult bindingResult instead of Errors errors
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@PathVariable(value = "id") long id, @Valid @RequestBody UpdateCustomerRequest request, Errors errors)
        {
            if (errors.hasErrors()) {
                throw new ValidationException("Some fields are not properly filled in");
            }
            var response = customerService.updateCustomer(request);
            return new ResponseEntity<UpdateCustomerResponse>(response, HttpStatus.OK);
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

    }



    @DeleteMapping("")
    public void deleteAllCustomers() {

        customerService.deleteAllCustomers();
    }


}











