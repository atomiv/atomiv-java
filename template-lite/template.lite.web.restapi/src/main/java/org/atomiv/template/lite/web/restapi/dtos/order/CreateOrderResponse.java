package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.CreateOrderItemResponse;

import java.util.List;

@Data
public class CreateOrderResponse {
    private Long id;
    private String orderAddress;
    private Long customerId;
    private String customerFirstName;
//    private Customer customer;
//    private Simple simple;
    private List<CreateOrderItemResponse> orderItems;
//    private List<OrderItem> orderItems;
}
