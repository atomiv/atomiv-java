package org.atomiv.template.lite.web.restapi.dtos.order_item;

import lombok.Data;

@Data
public class CreateOrderItemRequest {
    private Integer quantity;
    private Long productId;
//    private Product product;
}
