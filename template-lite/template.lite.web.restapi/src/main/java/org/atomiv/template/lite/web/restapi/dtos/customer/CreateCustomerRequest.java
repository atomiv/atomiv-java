package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.CreateAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.home_address.CreateHomeAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.GetAllOrdersResponse;

import java.util.List;

@Data
public class CreateCustomerRequest {

    private String firstName;

    private String lastName;

    private List<CreateAddressRequest> addresses;

    private CreateHomeAddressRequest homeAddress;

    // get orders by customer id
    // orderId
    // JUST GET THE ID
//    private List<GetAllOrdersResponse> orders;
    // get all customer orders or count orders
//    private List<Order> orders;
}
