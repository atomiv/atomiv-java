package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.address.*;
import org.atomiv.template.lite.web.restapi.dtos.customer.*;
import org.atomiv.template.lite.web.restapi.dtos.customer_order.GetCustomerOrderResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.*;
import org.atomiv.template.lite.web.restapi.dtos.order.GetOrderResponse;
import org.atomiv.template.lite.web.restapi.dtos.order_item.GetOrderItemResponse;
import org.atomiv.template.lite.web.restapi.dtos.product.CreateProductResponse;
import org.atomiv.template.lite.web.restapi.dtos.product.GetAllProductsResponse;
import org.atomiv.template.lite.web.restapi.dtos.product.UpdateProductResponse;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
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
    // Long or long
    public GetCustomerResponse getCustomerById(long id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {
            throw new ResourceNotFoundException(
                    new CustomerNotFoundException("Customer Not Found")
            );
        }

        var customer= optionalCustomer.get();


        var response = new GetCustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());


        // TODO ------------------------
        var customerOrderResponses = new ArrayList<GetCustomerOrderResponse>();
        for (Order order : customer.getOrders()) {
            var customerOrderResponse = new GetCustomerOrderResponse();
            customerOrderResponse.setId(order.getId());
            customerOrderResponse.setOrderAddress(order.getOrderAddress());

            var orderItemResponses = new ArrayList<GetOrderItemResponse>();
            for (OrderItem orderItem : order.getOrderItems()) {
                var product = orderItem.getProduct();
                var orderItemResponse = new GetOrderItemResponse();

                orderItemResponse.setId(orderItem.getId());
                orderItemResponse.setQuantity(orderItem.getQuantity());
                orderItemResponse.setProductId(product.getId());
                orderItemResponse.setProductName(product.getName());
                orderItemResponses.add(orderItemResponse);
            }
            customerOrderResponse.setOrderItems(orderItemResponses);

            customerOrderResponses.add(customerOrderResponse);
        }
        response.setOrders(customerOrderResponses);




//        for (Person p : list/persons) {
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

//        var order = orderRepository.findById(request.getOrderId()).get();
        // TODO orders is null when creating a customer.. so should this field even be shown
//        var orders = (List<Order>) orderRepository.findAll();

        var customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
//        customer.setOrders(orders);

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
//        response.setOrders(customer.getOrders());

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
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {

        var orders = (List<Order>) orderRepository.findAll();

        var id = request.getId();
        var optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found");
            // throw new RuntimeException("Cannot find the customer with id " + customer.getId());
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



//        var addresses = new ArrayList<Address>();
//        var address = new Address();
//        addresses.add(address);



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
    public void deleteCustomerById(long id) {
//        Optional<Customer> optionalCustomer = customerRepository.deleteById(id);

        customerRepository.deleteById(id);

        // --------------------------
        // return customerRepository.findById(customerId).map(customer -> {
        //                    customerRepository.delete(customer);
        //                    return ResponseEntity.ok().build();
        //                }
        //        ).orElseThrow(() -> new RuntimeException("Customer [customerId=" + customerId + "] can't be found"));
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

