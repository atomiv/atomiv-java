package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.UpdateAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.home_address.UpdateHomeAddressRequest;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class UpdateCustomerRequest {

    private Long id;

//    @Valid
    @NotNull(message = "First Name should not be empty") // not displayed - why??
    @NotEmpty // not working !!
    @NotBlank
    @Min(2)
    private String firstName;

    private String lastName;

    private List<UpdateAddressRequest> addresses;

    private UpdateHomeAddressRequest homeAddress;

//    private List<Order> orders;
    // should this be updated from here???
}
