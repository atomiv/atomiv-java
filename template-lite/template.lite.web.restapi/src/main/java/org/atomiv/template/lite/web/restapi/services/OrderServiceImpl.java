package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.models.Order;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.atomiv.template.lite.web.restapi.repositories.OrderItemRepository;
import org.atomiv.template.lite.web.restapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;



    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }


    @Override
    public Order getOrderById(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if(optionalOrder.isPresent())
            return optionalOrder.get();
        else
            throw new ResourceNotFoundException(new CustomerNotFoundException("Customer Not Found"));
    }


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public Order updateOrder(Order order) {

        Optional<Order> existingOrder =
                orderRepository.findById(order.getId());
        if(existingOrder.isEmpty()) {
            throw new RuntimeException("Cannot find the customer with id " + order.getId());
        }
        existingOrder.get().setOrderAddress(order.getOrderAddress());
        // TODO I had ths originally
        existingOrder.get().setOrderItems(order.getOrderItems());
        return orderRepository.save(existingOrder.get());
    }




    @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);
    }




}



