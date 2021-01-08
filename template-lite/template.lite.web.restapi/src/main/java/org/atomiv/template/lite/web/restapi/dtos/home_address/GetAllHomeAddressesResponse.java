package org.atomiv.template.lite.web.restapi.dtos.home_address;

import lombok.Data;

import java.util.List;

@Data
public class GetAllHomeAddressesResponse {
    public List<GetAllHomeAddressesRecordResponse> records;
}
