package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.address.*;
import org.atomiv.template.lite.web.restapi.dtos.customer.*;
import org.atomiv.template.lite.web.restapi.dtos.home_address.*;
import org.atomiv.template.lite.web.restapi.exceptions.ExistenceException;
import org.atomiv.template.lite.web.restapi.exceptions.ValidationException;
import org.atomiv.template.lite.web.restapi.models.*;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.atomiv.template.lite.web.restapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private OrderRepository orderRepository;


//    public List<Customer_Orders> findAllFirstName(String customer_first_name) {
//        return customerRepository.findAllByFirstName(customer_first_name);
//    }


    // https://www.baeldung.com/java-iterable-to-collection
    // Using Guava ... ImmutableList.copyOf():
    @Override
    public GetAllCustomersResponse getAllCustomers() {
        var customers = (List<Customer>) customerRepository.findAll();

        var records = new ArrayList<GetAllCustomersRecordResponse>();


        for(Customer customer : customers) {
            var record = new GetAllCustomersRecordResponse();
            record.setId(customer.getId());
            record.setFirstName(customer.getFirstName());
            record.setLastName(customer.getLastName());


            var homeAddressRecords = new ArrayList<GetAllHomeAddressesRecordResponse>();

                var homeAddressRecord = new GetAllHomeAddressesRecordResponse();
                homeAddressRecord.setId(customer.getHomeAddress().getId());
                homeAddressRecord.setCity(customer.getHomeAddress().getCity());
                homeAddressRecords.add(homeAddressRecord);

                record.setHomeAddress(homeAddressRecord);

//            ------------------------
            var addressRecords = new ArrayList<GetAllAddressesRecordResponse>();

            for (Address address : customer.getAddresses()) {
                var addressRecord = new GetAllAddressesRecordResponse();
                addressRecord.setId(address.getId());
                addressRecord.setCity(address.getCity());
                addressRecords.add(addressRecord);
            }
            record.setAddresses(addressRecords);

            records.add(record);

        }

        var response = new GetAllCustomersResponse();
        response.setRecords(records);


        return response;
    }

//    @Override
//    public List<Customer> findByFirstName(String firstName) {
//        return customerRepository.findByFirstName(firstName);
//        // return customerRepository.findAllByFirstNameContainingOrLastNameContaining(name, name);
//    }


    @Override
    public GetCustomerResponse getCustomerById(long id) throws ExistenceException {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {// result == null ??
            throw new ExistenceException("Customer not found with id ...  :" + id);
        }

        var customer= optionalCustomer.get();


        var response = new GetCustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());


        var addressResponses = new ArrayList<GetAddressResponse>();
        for (Address address : customer.getAddresses() ) {
            var addressResponse = new GetAddressResponse();
            addressResponse.setId(address.getId());
            addressResponse.setCity(address.getCity());
            addressResponses.add(addressResponse);
        }
        response.setAddresses(addressResponses);

        var homeAddressResponse = new GetHomeAddressResponse();
        homeAddressResponse.setId(customer.getHomeAddress().getId());
        homeAddressResponse.setCity(customer.getHomeAddress().getCity());
        response.setHomeAddress(homeAddressResponse);

        return response;
    }



    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        //logger.debug("save->customer:"+customer);

        // // if (result.hasErrors()) {
//        if (message.hasErrors)

        // TODO
        // if (employee.getName() == null || employee.getName().isEmpty()) {
        ////			throw new ServiceException("Name should not be empty or null", HttpStatus.BAD_REQUEST.value());

        // request.getParameter("ID_A") != null && !request.getParameter("ID_A").isEmpty()
        //|| request.getParameter("Password_A") && !request.getParameter("Password_A").isEmpty()

        // if ((isNullOrBlank(request.getParameter("ID_A"))||
        //     isNullOrBlank(request.getParameter("Password_A"))
        //    ) &&
        //    (isNullOrBlank(request.getParameter("ID_B"))||
        //     isNullOrBlank(request.getParameter("Password_B")))) {
        // TODO write in Fluent notation
//        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
//            throw new ValidationException("Some fields are null or empty");
//        }



        var customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());

        var addresses = new ArrayList<Address>();

        for (CreateAddressRequest addressRequest : request.getAddresses()) {
            var address = new Address();
            address.setCity(addressRequest.getCity());
            address.setCustomer(customer);
            addresses.add(address);
        }

        customer.setAddresses(addresses);

        var homeAddress = new HomeAddress();
        CreateHomeAddressRequest homeAddressRequest = request.getHomeAddress();
        homeAddress.setCity(homeAddressRequest.getCity());
        homeAddress.setCustomer(customer);

        customer.setHomeAddress(homeAddress);


        customerRepository.save(customer);



        var response = new CreateCustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());

        var addressResponses = new ArrayList<CreateAddressResponse>();

        for (Address address : customer.getAddresses()) {
            var addressResponse = new CreateAddressResponse();
            addressResponse.setId(address.getId());
            addressResponse.setCity(address.getCity());

            addressResponses.add(addressResponse);
        }

        response.setAddresses(addressResponses);

        var homeAddressResponse = new CreateHomeAddressResponse();
        homeAddressResponse.setId(homeAddress.getId());
        homeAddressResponse.setCity(homeAddress.getCity());

        response.setHomeAddress(homeAddressResponse);





        return response;



    }


    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws ValidationException {

//        if (request.getFirstName() == null) {
//            throw new ValidationException("First name is null");
//        }

//        if (request.getFirstName().isEmpty()) {
//            throw new ValidationException("First name is empty");
//        }

        var orders = (List<Order>) orderRepository.findAll();

        var id = request.getId();
        var optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {
            throw new ExistenceException("Customer does not exist with id:" + id);
        }

        var customer = optionalCustomer.get();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
//        customer.setOrders(request.getOrders());
        customer.setOrders(orders); // ???




        var addresses = new ArrayList<Address>();
        for (UpdateAddressRequest addressRequest : request.getAddresses()) {
            var address = new Address();
            address.setId(addressRequest.getId());
            address.setCity(addressRequest.getCity());
            address.setCustomer(customer);
            addresses.add(address);
//            customer.addAddress(address); // TODO - new thing but maybe there's issues
            customer.getAddresses().clear();
        }
//        customer.setAddresses(addresses);
        customer.getAddresses().addAll(addresses);


        var homeAddress = new HomeAddress();
        UpdateHomeAddressRequest homeAddressRequest = request.getHomeAddress();
        homeAddress.setId(homeAddressRequest.getId());
        homeAddress.setCity(homeAddressRequest.getCity());
        homeAddress.setCustomer(customer);
        customer.setHomeAddress(homeAddress);

        customerRepository.save(customer);

        var response = new UpdateCustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
//        response.setOrders(customer.getOrders());


        var addressResponses = new ArrayList<UpdateAddressResponse>();
        for (Address address : customer.getAddresses()) {
            var addressResponse = new UpdateAddressResponse();
            addressResponse.setId(address.getId());
            addressResponse.setCity(address.getCity());
            addressResponses.add(addressResponse);
        }
        response.setAddresses(addressResponses);


        var homeAddressResponse = new UpdateHomeAddressResponse();
        HomeAddress homeAddress1 = customer.getHomeAddress();

        homeAddressResponse.setId(homeAddress1.getId());
        homeAddressResponse.setCity(homeAddress1.getCity());

        response.setHomeAddress(homeAddressResponse);


        return response;


// ----------------------------------------------------
//        @PutMapping(value = "/{customerId}")
//        public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer newCustomer) {
//
//            return customerRepository.findById(customerId).map(customer -> {
//                customer.setCustomerName(newCustomer.getCustomerName());
//                customer.setPhoneNumber(newCustomer.getPhoneNumber());
//                customerRepository.save(customer);
//                return ResponseEntity.ok(customer);
//            }).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
//
//        }

    }




    @Override
    public void deleteCustomerById(long id) throws ExistenceException {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {
            throw new ExistenceException("Customer not found with id ...  :" + id);
        }

        customerRepository.deleteById(id);

        // --------------------------
        // return customerRepository.findById(customerId).map(customer -> {
        //                    customerRepository.delete(customer);
        //                    return ResponseEntity.ok().build();
        //                }
        //        ).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
    }
    /*
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

       employeeRepository.delete(employee);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }
     */



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

