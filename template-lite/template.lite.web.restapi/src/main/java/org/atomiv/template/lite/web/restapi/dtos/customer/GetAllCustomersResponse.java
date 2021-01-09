package org.atomiv.template.lite.web.restapi.dtos.customer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllCustomersResponse {

    public List<GetAllCustomersRecordResponse> records;

}
