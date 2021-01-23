package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;

import java.util.List;

@Data
public class GetOrdersByCustomerIdResponse {
    public List<GetOrdersByCustomerIdRecordResponse> records;
}
