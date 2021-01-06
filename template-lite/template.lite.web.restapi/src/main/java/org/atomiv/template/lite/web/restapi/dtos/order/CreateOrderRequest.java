package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String orderAddress;
    private Long customerId;
//    private Simple simple;
//    private List<OrderItem> orderItems;
}
