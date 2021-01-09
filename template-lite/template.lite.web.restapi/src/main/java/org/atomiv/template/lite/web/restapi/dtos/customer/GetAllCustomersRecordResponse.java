package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.GetAllAddressesRecordResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.GetAllHomeAddressesRecordResponse;

import java.util.List;

@Data
public class GetAllCustomersRecordResponse {

    private Long id;

    private String firstName;

    private String lastName;

//    private List<Address> addresses;
    private List<GetAllAddressesRecordResponse> addresses;

    private GetAllHomeAddressesRecordResponse homeAddress;


//    private List<Order> orders;
}
