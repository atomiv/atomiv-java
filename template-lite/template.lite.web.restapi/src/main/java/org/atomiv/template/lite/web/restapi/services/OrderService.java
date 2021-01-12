package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.order.*;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.models.Order;

import java.util.List;

public interface OrderService {
    GetAllOrdersResponse getAllOrders();

    GetOrderResponse getOrderById(long id);

    CreateOrderResponse createOrder(CreateOrderRequest request);

    UpdateOrderResponse updateOrder(UpdateOrderRequest request);

    void deleteOrderById(long id);

}
