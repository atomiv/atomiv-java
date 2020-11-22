package org.atomiv.template.lite.web.restapi.controllers;

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
// Create Rest Controllers and Map API Requests
@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

// @Autowired
// private IProductService productService;

//    private CustomerService customerService;
//
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }
// -------------------------------------
//    List products = Arrays.asList(
//            new Product("1","G Tech", "G Tech Hard drive", 230.45, 25),
//            new Product("2","WD SSD", "WD HDD", 150, 15),
//            new Product("3","Samsung SSD", "Samsung Solid State Drive", 100, 12),
//            new Product("5","Sandisk Pen Drive", "Sandisk Pen Drive", 12, 200)
//    );

    // --------------------------------------------------

//    private static Map<String, Product> productRepo = new HashMap<>();
//    static {
//        Product honey = new Product();
//        honey.setId("1");
//        honey.setName("Honey");
//        productRepo.put(honey.getId(), honey);
//
//        Product almond = new Product();
//        almond.setId("2");
//        almond.setName("Almond");
//        productRepo.put(almond.getId(), almond);
//    }




//    @GetMapping("/customers/orders/{customer_first_name}")
//    public List<Customer_Orders> findAllByFirstName(@PathVariable(value="customer_first_name") String customer_first_name) {
//        return customerService.findAllFirstName(customer_first_name);
//    }


    /**
     * Get all customers list
     * @return the list
     */
    // (value = "/products", produces =
    // note: path = "/" causes 404 not found
    @GetMapping(path = "", produces = "application/json")
    // public ResponseEntity<Object> getProduct() {
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        // 'list' or 'customers'
        List<Customer> list = customerService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
        // return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

//    @GetMapping(path ="/customers")
//    public Iterable<Customer> findAll() {
//        Iterable<Customer> customers = customerService.findAll();
//        return customers;
//    }


//     * @throws ResourceNotFoundException the resource not found exception
    /**
     * Get customer by id
     *
     * @param id the customer id
     * @return the customer by id
     */
    // , produces = MediaType.APPLICATION_JSON_VALUE
    @GetMapping("/{id}")
    // public Resource<User> ... Resource or ResponseEntity
    // public Company getCompanyById(
    // Long or long
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id)
    {
        try {
            return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer Not Found");
        }
        //System.out.println(customer);
    }

    @GetMapping("/search/firstname/{firstname}")
    public List<Customer> searchByFirstName(@PathVariable String firstName){
        return customerService.findByFirstName(firstName);
//        Customer customer = customerRepository.findByCustomerName(customerName);
//        return customer;
    }


    /**
     * Create customer
     *
     * @param customer the customer
     * @return the customer
     */
    // path = ""
    // GUESSING
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    // or just - public Customer createCustomer(...
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer)
    {
        //Customer savedCustomer = customerService.save(customer);
        return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.OK);

//        customerRepository.save(customer);
//        return ResponseEntity.ok().body(customer);
    }


    /**
     * Update customer response entity
     *
     * @param id the customer id
     * @param customer the customer details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    // @RequestBody Customer customerDetails ... {
    //                Customer customer
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id, @Valid @RequestBody Customer customer)
            {
                return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
            }



    /**
     * Delete customer // delete customer map
     * @param id the customer id
     * @return the map
     * @throws ResourceNotFoundException the resource not found
     */
    @DeleteMapping("/{id}")
    // customerId or id ??
    // public Map<String, Boolean> deleteCustomer
    // public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        //Customer customer = customerService.deleteCustomerById(id);
//        return "Delete Success";
//        if(customer==null)
//            throw new CustomerNotFoundException("id: " + id);
    }

    @DeleteMapping("")
    public void deleteAllCustomers() {
        customerService.deleteAllCustomers();
    }



//        throws ResourceNotFoundException {
//            Customer customer =
//                customerRepository
//                    .findById(customerId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found for id: " + customerId));
//                customerRepository.deleteById(customerId);
//                return ResponseEntity.ok().build();
//    }

}



// https://www.javadevjournal.com/spring/exception-handling-for-rest-with-spring/
// TODO is this good?

//    @GetMapping("/customer/{id}")
//    public Customer getCustomer(@PathVariable long id) throws CustomerNotFoundException {
//        if (id == 1) {
//            throw new CustomerNotFoundException();
//        }
//        return new Customer();
//    }
//
//    @ExceptionHandler({CustomerNotFoundException.class})
//    public String handleException() {
//        return "bad_request";
//    }





//    HTTP Patch request example
//
//    @PatchMapping("/customers/{id}")
//    public ResponseEntity < ? > updateResource(@RequestParam("email") String email, @PathVariable("id") String id) {
//        Customer newCustomer = customerService.updateCustomer(email, id);
//        return new ResponseEntity < > (newCustomer, HttpStatus.OK);