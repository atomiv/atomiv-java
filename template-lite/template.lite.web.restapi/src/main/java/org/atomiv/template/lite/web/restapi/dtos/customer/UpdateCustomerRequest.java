package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private Long id;

    private String firstName;

    private String lastName;

//    private List<Address> addresses;

//    private HomeAddress homeAddress;

//    private List<Order> orders;
}
