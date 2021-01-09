package org.atomiv.template.lite.web.restapi.dtos.address;

import lombok.Data;

import java.util.List;

@Data
public class GetAllAddressesResponse {
    public List<GetAllAddressesRecordResponse> records;
}
