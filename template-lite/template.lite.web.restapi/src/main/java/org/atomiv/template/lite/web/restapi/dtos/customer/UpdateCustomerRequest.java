package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.address.UpdateAddressRequest;
import org.atomiv.template.lite.web.restapi.dtos.home_address.UpdateHomeAddressRequest;
import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.*;
import java.util.List;


@Data
public class UpdateCustomerRequest {

    private Long id;

    private String firstName;

    /* DISPLAY THIS MESSAGE - last part of it
    javax.validation.ConstraintViolationException: Validation failed for classes [org.atomiv.template.lite.web.restapi.models.Customer] during update time for groups [javax.validation.groups.Default, ]\nList of constraint violations:[\n\tConstraintViolationImpl{interpolatedMessage='Last name can't be less than 3 or bigger than 9', propertyPath=lastName, rootBeanClass=class org.atomiv.template.lite.web.restapi.models.Customer, messageTemplate='Last name can't be less than 3 or bigger than 9'}\n]
     */

    @Size(min = 3, max = 8, message = "Last name can't be less than 3 or bigger than 6")
    @NotNull
    @NotEmpty(message = "Last name {value} ${value} must not be blank")
    private String lastName;

    private List<UpdateAddressRequest> addresses;

    private UpdateHomeAddressRequest homeAddress;

}
