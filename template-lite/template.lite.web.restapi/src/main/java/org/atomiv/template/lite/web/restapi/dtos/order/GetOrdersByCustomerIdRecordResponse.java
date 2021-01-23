package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.GetAllOrderItemsRecordResponse;

import java.util.List;

@Data
public class GetOrdersByCustomerIdRecordResponse {
    private Long id;
    private String orderAddress;
    private List<GetAllOrderItemsRecordResponse> orderItems;
}
