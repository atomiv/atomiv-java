package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(long id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrderById(long id);

}
