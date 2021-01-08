package org.atomiv.template.lite.web.restapi.dtos.home_address;

import lombok.Data;

@Data
public class UpdateHomeAddressRequest {
    private Long id;
    private String city;
}
