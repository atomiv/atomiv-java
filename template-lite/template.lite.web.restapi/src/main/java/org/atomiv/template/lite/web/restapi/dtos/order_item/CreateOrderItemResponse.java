package org.atomiv.template.lite.web.restapi.dtos.order_item;

import lombok.Data;

@Data
public class CreateOrderItemResponse {
    private Long id;
    private Integer quantity;
    private Long productId;
    private String productName;
}
