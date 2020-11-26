package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.models.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(long id);

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(OrderItem orderItem);

    // ?? or delete ALL
    void deleteOrderItemById(long id);
}


