package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Address;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    // TODO Logging
    // private Logger logger= LoggerFactory.getLogger(this.getClass());

    // save a couple of customers
//    repository.save(new Customer("Alice", "Smith"));
//    repository.save(new Customer("Bob", "Smith"));


    @Autowired
    private CustomerRepository customerRepository;


//    public List<Customer_Orders> findAllFirstName(String customer_first_name) {
//        return customerRepository.findAllByFirstName(customer_first_name);
//    }


    // https://www.baeldung.com/java-iterable-to-collection
    // Using Guava ... ImmutableList.copyOf():
    @Override
    public List<Customer> getAllCustomers() {
        // logger.debug("findAll");
//        return customerList;
        return (List<Customer>) customerRepository.findAll();
        // return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
        // return customerRepository.findAllByFirstNameContainingOrLastNameContaining(name, name);
    }


    //@GetMapping("/customers/{id}")
    //    Customer one(@PathVariable Long id) {
    //        return customerRepository.findById(id)
    //                .orElseThrow(() -> new NotFoundException(id));
    //    }
    @Override
    // Long or long
    public Customer getCustomerById(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isPresent())
            return optionalCustomer.get();
        else
//            throw new CustomerNotFoundException("Customer Not Found");
            throw new ResourceNotFoundException(new CustomerNotFoundException("Customer Not Found"));
    }
    // try {
    //            Long customerIdLong = Long.valueOf(customerId);
    //            Customer customer = customerService.getCustomerById(customerIdLong)
    //                    .orElseThrow(()->new RuntimeException("Unable to fetch customer record with id = " + customerId));
    //            return ResponseEntity.ok(customer);
    //        }catch(Exception ex) {
    //            return handleException(ex);
    //        }
    // -----------------
    // return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));

    // TODO
    //@Override
    //    public Customer save(Customer customer) {
    //
    //   h     return customerRepository.save(customer);
    //    }


    @Override
    public Customer createCustomer(Customer customer) {
        //logger.debug("save->customer:"+customer);
//        customer.getAddresses();
        //order.getOrderItems().add(orderItem);

        for (Address address : customer.getAddresses()) {
            address.setCustomer(customer);
        }

        return customerRepository.save(customer);
    }


    @Override
    public Customer updateCustomer(Customer customer) {

        Optional<Customer> existingCustomer =
                customerRepository.findById(customer.getId());
        if(existingCustomer.isEmpty()) {
            throw new RuntimeException("Cannot find the customer with id " + customer.getId());
        }
        existingCustomer.get().setFirstName(customer.getFirstName());
        existingCustomer.get().setLastName(customer.getLastName());
        return customerRepository.save(existingCustomer.get());

//        Customer newCustomer = existingCustomer.get();
//        newCustomer.setAddresses(customer.getAddresses());
//        newCustomer.setFirstName(customer.getFirstName());
//        newCustomer.setLastName(customer.getLastName());
//        return customerRepository.save(newCustomer);

        // ---------------------------------------------
        // FROM BEFORE
//        customer.setFirstName(customer.getFirstName());
//        customer.setLastName(customer.getLastName());
//        return customerRepository.save(customer);

// ----------------------------------------------------
        // return customerRepository.findById(customerId).map(customer -> {
        //            customer.setCustomerName(newCustomer.getCustomerName());
        //            customer.setDateofBirth(newCustomer.getDateofBirth());
        //            customer.setPhoneNumber(newCustomer.getPhoneNumber());
        //            customerRepository.save(customer);
        //            return ResponseEntity.ok(customer);
        //        }).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
// -------------------------------------
        //try {
        //            customer.setId(Long.valueOf(customerId));
        //            Customer updatedCustomer = customerService.update(customer);
        //            return ResponseEntity.ok(updatedCustomer);
        //        }catch(Exception ex) {
        //            return handleException(ex);
        //        }
        // ------------------------------------------
        //@PutMapping("/customers/{id}")
        // CHECK
        //    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        //        return customerRepository.findById(id)
        //                .map(customer -> {
        //                    customer.setUser(newCustomer.getUser());
        //                    customer.setWallet(newCustomer.getWallet());
        //                    customer.setOrderList(newCustomer.getOrderList());
        //                    return customerRepository.save(customer);
        //                })
        //                .orElseGet(() -> {
        //                    newCustomer.setId(id);
        //                    return customerRepository.save(newCustomer);
        //                });
        //    }



//        @PutMapping(value = "/{customerId}")
//        public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer newCustomer) {
//
//            return customerRepository.findById(customerId).map(customer -> {
//                customer.setCustomerName(newCustomer.getCustomerName());
//                customer.setDateofBirth(newCustomer.getDateofBirth());
//                customer.setPhoneNumber(newCustomer.getPhoneNumber());
//                customerRepository.save(customer);
//                return ResponseEntity.ok(customer);
//            }).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
//
//        }



//        try {
//            Customer newCustomer = customerRepository
//                    .findById(id)
//                    .orElseThrow(() -> new ResourceNotFoundException(" " + id));
//            customer.setFirstName(newCustomer.getFirstName());
//            customer.setLastName(newCustomer.getLastName());
//            customerRepository.save(customer);
//            return ResponseEntity.ok;
//        } catch (ResourceNotFoundException e) {
//            e.printStackTrace();
//        }


//                        customerRepository
//                        .findById(customerId)
//                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for id: " + customerId));
//                customer.setFirstName(customerDetails.getFirstName());
//                customer.setLastName(customerDetails.getLastName());
//                customerRepository.save(customer);
//                return ResponseEntity.ok().body(customer);
    }




    @Override
    public void deleteCustomerById(long id) {
//        Optional<Customer> optionalCustomer = customerRepository.deleteById(id);
//
//        if(optionalCustomer.isPresent())
//            return optionalCustomer.

        customerRepository.deleteById(id);
        // not working- customerRepository.delete(customer);

//        Customer deleteCustomer = customerRepository.findById(id);
//        customerRepository.delete(deleteCustomer);
        // --------------------------
        // return customerRepository.findById(customerId).map(customer -> {
        //                    customerRepository.delete(customer);
        //                    return ResponseEntity.ok().build();
        //                }
        //        ).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
    }


    // public void deleteAll() {
    //        logger.debug("deleteAll");
    //        customerRepository.deleteAll();
    //    }


    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

}



//    @DeleteMapping(value = "/{customerId}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
//
//        return customerRepository.findById(customerId).map(customer -> {
//                    customerRepository.delete(customer);
//                    return ResponseEntity.ok().build();
//                }
//        ).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
//
//    }

// --------------------------------------------
//private ResponseEntity<ErrorMessage> handleException(Exception ex) {
//        ex.printStackTrace();
//        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//        return ResponseEntity.badRequest().body(error);
//    }
//-------------
//For handling errors, you will need to create a custom Error class, that is returned if any exception occurs. The class definition is as follows
//
//@Data
//@AllArgsConstructor
//public class ErrorMessage {
//    private int statusCode;
//    private String errorMessage;
//}

//--------------------------
//@PutMapping("/students/{id}")
//public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
//
//	Optional<Student> studentOptional = studentRepository.findById(id);
//
//	if (!studentOptional.isPresent())
//		return ResponseEntity.notFound().build();
//
//	student.setId(id);
//
//	studentRepository.save(student);
//
//	return ResponseEntity.noContent().build();
//}