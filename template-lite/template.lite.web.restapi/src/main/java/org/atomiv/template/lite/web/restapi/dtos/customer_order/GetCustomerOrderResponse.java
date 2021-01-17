package org.atomiv.template.lite.web.restapi.dtos.customer_order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.GetAllOrderItemsRecordResponse;
import org.atomiv.template.lite.web.restapi.dtos.order_item.GetOrderItemResponse;

import java.util.List;

@Data
public class GetCustomerOrderResponse {
    private Long id;
    private String orderAddress;
    private List<GetOrderItemResponse> orderItems;
}
