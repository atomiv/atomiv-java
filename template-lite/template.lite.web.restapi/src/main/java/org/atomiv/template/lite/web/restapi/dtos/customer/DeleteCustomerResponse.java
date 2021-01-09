package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.DeleteAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.DeleteHomeAddressResponse;

import java.util.List;

@Data
public class DeleteCustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

//    private List<Address> addresses;
    private List<DeleteAddressResponse> addresses;

//    private HomeAddress homeAddress;
    private DeleteHomeAddressResponse homeAddress;

//    private List<Order> orders;
}
