package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.dtos.order.*;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.OrderNotFoundException;
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
    public ResponseEntity<GetAllOrdersResponse> getAllOrders()
    {
        var response = orderService.getAllOrders();
        return new ResponseEntity<GetAllOrdersResponse>(response, HttpStatus.OK);
    }



    @GetMapping("{id}")
    public ResponseEntity<GetOrderResponse> getOrderById(@PathVariable("id") Long id)
    {
        var response = orderService.getOrderById(id);

        if(response == null) {
            throw new OrderNotFoundException("Order not found");
        }

        return new ResponseEntity<GetOrderResponse>(response, HttpStatus.OK);

    }


    @PostMapping(path = "")
    public ResponseEntity<CreateOrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request)
    {
        var response = orderService.createOrder(request);
        return new ResponseEntity<CreateOrderResponse>(response, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<UpdateOrderResponse> updateOrder(@PathVariable(value = "id") Long id, @Valid @RequestBody UpdateOrderRequest request)
    {
        var response = orderService.updateOrder(request);
        return new ResponseEntity<UpdateOrderResponse>(response, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
//    public void deleteOrder(@PathVariable Long id) {
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
