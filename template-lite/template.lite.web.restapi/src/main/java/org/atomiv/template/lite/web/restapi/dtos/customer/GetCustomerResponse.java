package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.GetAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.customer_order.GetCustomerOrderResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.GetHomeAddressResponse;

import java.util.List;

@Data
public class GetCustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private List<GetAddressResponse> addresses;

    private GetHomeAddressResponse homeAddress;

    // TODO check GetOrderResponse .. GetAllOrdersResponse
    // <GetOrderResponse> - working
    private List<GetCustomerOrderResponse> orders;

}
