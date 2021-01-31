package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.CreateAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.home_address.CreateHomeAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.GetAllOrdersResponse;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class CreateCustomerRequest {

    // @valid annotation
    // @NotEmpty is Hibernate specific you should use @NotNull if you want to validate your beans through JSR-303. ???
//    @NotNull (message = "First Name should not be empty") // not displayed - why??
//    @NotEmpty // not working !!
//    @NotBlank
//    @Min(2)
    private String firstName;

//    @Min(value = 1, message = "Last name can't be less than 1 or bigger than 50")
//    @Max(10) // working but 500 error is thrown
//    @NotNull(message = "Last Name should not be empty")
    // @Size(max = 50, message = "LastName should not exceed 50 characters")
    // @Size(min=2, max=20)

    // TODO I get 400 Bad Request, but if I have the code below it throws the catch all
    // TODO need stuff below so that in postman ErrorDetails<> comes up
    @Size(min = 3, max = 9, message = "Last name can't be less than 3 or bigger than 9")
//    @Column(name = "last_name", length = 8) // 8 registered before, now it's 9
    @NotNull // same as 'nullable = false' // 400 error - 400 Bad Request
    @NotBlank
    private String lastName;

    private List<CreateAddressRequest> addresses;

    private CreateHomeAddressRequest homeAddress;

    // @NotNull(message = "Email cannot be empty")
    //     @Size(max = 50, message = "Email cannot exceed 50 characters")
    //     @Pattern(regexp = EMAIL_REGEX_PATTERN, message = "Email should contain a valid email address.")
    //     private String email;


    // @Min, @Max, @Size, @NotNull, and @Pattern are standard annotations

    // @Pattern(regexp = "^asc|desc$")
    //  private String order = "asc";

    // @Email

    // get orders by customer id
    // orderId
    // JUST GET THE ID
//    private List<GetAllOrdersResponse> orders;
    // get all customer orders or count orders
//    private List<Order> orders;
}
