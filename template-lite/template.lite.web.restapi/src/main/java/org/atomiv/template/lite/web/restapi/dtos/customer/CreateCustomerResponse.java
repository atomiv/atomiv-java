package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.CreateAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.CreateHomeAddressResponse;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class CreateCustomerResponse {

    private Long id;

    // TODO - add validation here ?????????
//    @NotNull(message = "First Name should not be empty") // not displayed - why??
//    @NotEmpty // not working !!
//    @NotBlank
//    @Min(2)
    private String firstName;

    // TODO - add validation here ?????????
//    @Size(min = 3, max = 9, message = "Last name can't be less than 3 or bigger than 9")
////    @Column(name = "last_name", length = 8) // 8 registered before, now it's 9
//    @NotNull // same as 'nullable = false' // 400 error - 400 Bad Request
//    @NotBlank
    private String lastName;

    private List<CreateAddressResponse> addresses;

    private CreateHomeAddressResponse homeAddress;

//    private List<GetAllOrdersResponse> orders;
//    private List<Order> orders;
}
