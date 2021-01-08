package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.GetAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.GetHomeAddressResponse;

import java.util.List;

@Data
public class GetCustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private List<GetAddressResponse> addresses;

//    private List<Address> addresses;

    private GetHomeAddressResponse homeAddress;
//    private HomeAddress homeAddress;

//    private List<Order> orders;
}
