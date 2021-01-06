package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;

@Data
public class CreateOrderResponse {
    private Long id;
    private String orderAddress;
    private Long customerId;
    private String customerFirstName;
//    private Customer customer;
//    private Simple simple;
//    private List<OrderItem> orderItems;
}
