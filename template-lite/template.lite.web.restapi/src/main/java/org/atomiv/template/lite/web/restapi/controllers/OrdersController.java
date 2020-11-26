package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Order;
import org.atomiv.template.lite.web.restapi.services.CustomerService;
import org.atomiv.template.lite.web.restapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {

    private OrderService orderService;

    // TODO remove
    private CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping(path = "")
    public ResponseEntity<List<Order>> getAllOrders()
    {
        List<Order> list = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
    }



    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id)
    {
        try {
            return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order Not Found");
        }
    }


    @PostMapping(path = "")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order)
    {
        var newOrder = orderService.createOrder(order);
        return new ResponseEntity<Order>(newOrder, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long id, @Valid @RequestBody Order order)
    {
        return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}