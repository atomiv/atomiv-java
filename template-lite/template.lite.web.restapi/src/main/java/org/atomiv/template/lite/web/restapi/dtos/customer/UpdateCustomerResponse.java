package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.GetAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.address.UpdateAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.GetHomeAddressResponse;
import org.atomiv.template.lite.web.restapi.dtos.home_address.UpdateHomeAddressResponse;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateCustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private List<UpdateAddressResponse> addresses;

    private UpdateHomeAddressResponse homeAddress;

//    private List<Order> orders;
}
