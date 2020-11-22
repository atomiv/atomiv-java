package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// CustomerService implements ICustomerService
@Service
public class CustomerServiceImpl implements CustomerService {

    // save a couple of customers
//    repository.save(new Customer("Alice", "Smith"));
//    repository.save(new Customer("Bob", "Smith"));

    @Autowired
//    public void setCustomerRepository(CustomerRepository customerRepository) {
//        System.out.println("setter injection");
//        this.customerRepository = customerRepository;
//    }
    private CustomerRepository customerRepository;


    // TODO is this good?
//    @Autowired
//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        super();
//        this.customerRepository = customerRepository;
//    }
//    public List<Customer_Orders> findAllFirstName(String customer_first_name) {
//        return customerRepository.findAllByFirstName(customer_first_name);
//    }



    @Override
    public List<Customer> getAllCustomers() {
//        List<Customer> customerList = customerRepository.findAll();
//        return customerList;
        return (List<Customer>) customerRepository.findAll();
        // return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }


    @Override
    public Customer getCustomerById(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isPresent())
            return optionalCustomer.get();
        else
            throw new CustomerNotFoundException("Customer Not Found");
    }

    //
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // guess
    // newCustomer or customer
    @Override
    public Customer updateCustomer(Customer customer) {
        // return customer; // ---- change

        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        return customerRepository.save(customer);

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


    // guessing
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
    }

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