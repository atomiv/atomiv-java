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
// Create Rest Controllers and Map API Requests
@RestController
@RequestMapping("api/customers")
public class CustomersController {

    // private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;


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
//--------------------------------------
    //@RequestMapping(value ="/book3", produces =MediaType.APPLICATION_JSON_VALUE )
    //public ResponseEntity<Book> bookInfo3() {
    //    Book book = new Book();
    //    book.setBookName("Ramayan");
    //    book.setWriter("Valmiki");
    //    return ResponseEntity.accepted().body(book);
    //}
//    ---------------------------------



//    @GetMapping("/customers/orders/{customer_first_name}")
//    public List<Customer_Orders> findAllByFirstName(@PathVariable(value="customer_first_name") String customer_first_name) {
//        return customerService.findAllFirstName(customer_first_name);
//    }


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
    //
    @GetMapping("{id}")
    // public Resource<User> ... Resource or ResponseEntity
    // public Company getCompanyById(
    // Long or long
    // GLOBAL HANDLER
    public ResponseEntity<GetCustomerResponse> getCustomerById(@PathVariable("id") Long id)
    {
        var response = customerService.getCustomerById(id);

        if(response == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return new ResponseEntity<GetCustomerResponse>(response, HttpStatus.OK);
    }


//    // not via path variables but query
//    @GetMapping("/search/firstname/{firstname}")
//    public List<Customer> searchByFirstName(@PathVariable String firstName){
//        return customerService.findByFirstName(firstName);
////        Customer customer = customerRepository.findByCustomerName(customerName);
////        return customer;
//    }


    /**
     * Create customer
     *
     * @param customer the customer
     * @return the customer
     */
    @PostMapping(path = "")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request)
    {
        var response= customerService.createCustomer(request);
        return new ResponseEntity<CreateCustomerResponse>(response, HttpStatus.OK);
    }


    /**
     * Update customer response entity
     *
     * @param id the customer id
     * @param customer the customer details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("{id}")
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@PathVariable(value = "id") Long id, @Valid @RequestBody UpdateCustomerRequest request)
        {
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
//        if(customer==null)
//            throw new CustomerNotFoundException("id: " + id);
    }




    @DeleteMapping("")
    public void deleteAllCustomers() {

        customerService.deleteAllCustomers();
    }


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


// ---------------------------------

//@GetMapping("getAllCustomer")
//    public ResultInfo getAllCustomer() {
//        logger.info("getAllCustomer");
//        ResultInfo<Customer> resultInfo= new ResultInfo<>();
//        List<Customer> lCustomer=customerService.findAll();
//        resultInfo.setLData(lCustomer);
//        if(lCustomer.size()==0){
//            resultInfo.setErrCode("0001");
//            resultInfo.setErrmsg("查无数据");
//        }else{
//
//            resultInfo.setErrCode("0000");
//            resultInfo.setErrmsg("查询成功");
//        }
//        return resultInfo;
//    }
//
//@GetMapping("getCustomer")
//    public ResultInfo getCustomer(String CustomerId) {
//        logger.info("getCustomer请求参数:" + CustomerId);
//        ResultInfo<Customer> resultInfo= new ResultInfo<>();
//
//        if(CustomerId==null || "".equals(CustomerId.trim())){
//            resultInfo.setErrCode("1001");
//            resultInfo.setErrmsg("查询Id为空");
//            return resultInfo;
//        }
//
//        List<Customer> customer=customerService.findCustomerById(Integer.parseInt(CustomerId));
////        Long lCnt=customerService.count();
//        resultInfo.setLData(customer);
////        logger.info("lCnt="+lCnt);
//        if(customer.size()==0)
//        {
//            resultInfo.setErrCode("0001");
//            resultInfo.setErrmsg("查无数据");
//
//        }else{
//            resultInfo.setErrCode("0000");
//            resultInfo.setErrmsg("查询成功");
//        }
//        return resultInfo;
//    }
//
//
//
//    @PostMapping("saveCustomer")
//    public ResultInfo<Customer> saveCustomer(Customer customer) {
//        logger.info("saveCustomer请求参数:" + customer.toString());
//        ResultInfo resultInfo = new ResultInfo();
//        List<Customer> lCustomer = new ArrayList();
//        Customer newCustomer = customerService.save(customer);
//        lCustomer.add(newCustomer);
//        resultInfo.setLData(lCustomer);
//        resultInfo.setErrmsg("数据保存成功");
//        resultInfo.setErrCode("0000");
//        return resultInfo;
//    }

