package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.CreateAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.home_address.CreateHomeAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderRequest;

import java.util.List;

@Data
public class CreateCustomerRequest {

    private String firstName;

    private String lastName;

    private List<CreateAddressRequest> addresses;

    private CreateHomeAddressRequest homeAddress;

    private List<CreateOrderRequest> orders;

//    private List<Order> orders;
}
