package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.CreateAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.CreateHomeAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderResponse;

import java.util.List;

@Data
public class CreateCustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private List<CreateAddressResponse> addresses;

    private CreateHomeAddressResponse homeAddress;

    private List<CreateOrderResponse> orders;

//    private List<Order> orders;
}
