package org.atomiv.template.lite.web.restapi.dtos.customer_order;

import lombok.Data;

import java.util.List;

@Data
public class GetAllCustomerOrdersResponse {
    public List<GetAllCustomerOrdersRecordResponse> records;
}
