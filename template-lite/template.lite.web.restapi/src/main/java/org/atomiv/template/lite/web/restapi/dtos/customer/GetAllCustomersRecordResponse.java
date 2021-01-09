package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.home_address.GetAllHomeAddressesRecordResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.GetAllHomeAddressesResponse;

@Data
public class GetAllCustomersRecordResponse {

    private Long id;

    private String firstName;

    private String lastName;

//    private List<Address> addresses;

    // JELENA - or should it be
    // GetAllHomeAddressesResponse ??
    private GetAllHomeAddressesRecordResponse homeAddress;

//    private HomeAddress homeAddress;

//    private List<Order> orders;
}
