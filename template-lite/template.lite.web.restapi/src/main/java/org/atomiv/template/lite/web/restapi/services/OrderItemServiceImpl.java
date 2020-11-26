package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Order;
import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.atomiv.template.lite.web.restapi.repositories.OrderItemRepository;
import org.atomiv.template.lite.web.restapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return (List<OrderItem>) orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(long id) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);

        if(optionalOrderItem.isPresent())
            return optionalOrderItem.get();
        else
            throw new ResourceNotFoundException(new CustomerNotFoundException("Customer Not Found"));
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        OrderItem newOrderItem = orderItemRepository.save(orderItem);

        return newOrderItem;

        // return orderRepository.save(order);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        Optional<OrderItem> existingOrderItem =
                orderItemRepository.findById(orderItem.getId());
        if (existingOrderItem.isEmpty()) {
            throw new RuntimeException("Cannot find customer with id: " + orderItem.getId());
        }
        existingOrderItem.get().setQuantity(orderItem.getQuantity());
        existingOrderItem.get().setProduct(orderItem.getProduct());
        // ?
        existingOrderItem.get().setOrder(orderItem.getOrder());
        return orderItemRepository.save(existingOrderItem.get());
    }


    // ?? or delete all
    @Override
    public void deleteOrderItemById(long id) {
        orderItemRepository.deleteById(id);
    }
}

