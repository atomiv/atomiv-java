package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.UpdateOrderItemRequest;

import java.util.List;

@Data
public class UpdateOrderRequest {
    private Long id;
    private String orderAddress;
    private Long customerId;
//    private String customerFirstName;
    private List<UpdateOrderItemRequest> orderItems;
}
