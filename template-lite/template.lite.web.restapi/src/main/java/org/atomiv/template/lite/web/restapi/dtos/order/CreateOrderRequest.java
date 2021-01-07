package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.CreateOrderItemRequest;

import java.util.List;

@Data
public class CreateOrderRequest {
    private String orderAddress;
    private Long customerId;
    private List<CreateOrderItemRequest> orderItems;
}
