package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderResponse;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(long id);

    CreateOrderResponse createOrder(CreateOrderRequest request);

    Order updateOrder(Order order);

    void deleteOrderById(long id);

}
