package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.UpdateAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.home_address.UpdateHomeAddressRequest;

import java.util.List;

@Data
public class UpdateCustomerRequest {

    private Long id;

    private String firstName;

    private String lastName;

//    private List<Address> addresses;
    private List<UpdateAddressRequest> addresses;

//    private HomeAddress homeAddress;
    private UpdateHomeAddressRequest homeAddress;

//    private List<Order> orders;
    // should this be updated from here???
}
