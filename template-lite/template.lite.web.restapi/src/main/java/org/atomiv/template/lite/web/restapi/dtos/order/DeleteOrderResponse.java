package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;
import org.atomiv.template.lite.web.restapi.dtos.order_item.DeleteOrderItemResponse;

import java.util.List;

@Data
public class DeleteOrderResponse {
    private Long id;
    private String orderAddress;
//    private Long customerId; // TODO ??
//    private String customerFirstName; // TODO ??
    private List<DeleteOrderItemResponse> orderItems;
}
