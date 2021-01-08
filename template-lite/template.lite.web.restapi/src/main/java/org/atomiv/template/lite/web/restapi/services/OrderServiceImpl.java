package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.order_item.CreateOrderItemRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderRequest;
import org.atomiv.template.lite.web.restapi.dtos.order.CreateOrderResponse;
import org.atomiv.template.lite.web.restapi.dtos.order_item.CreateOrderItemResponse;
import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.*;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.atomiv.template.lite.web.restapi.repositories.OrderRepository;
import org.atomiv.template.lite.web.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Order> getAllOrders() {
//data-examples-master

        //sorting-master --> tutorials
        // List<Tutorial> tutorials = tutorialRepository.findAll(Sort.by(orders));
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
    public CreateOrderResponse createOrder(CreateOrderRequest request) {

        var customer = customerRepository.findById(request.getCustomerId()).get();


        var order = new Order();
        order.setOrderAddress(request.getOrderAddress());
        order.setCustomer(customer);

        var orderItems = new ArrayList<OrderItem>();

        for (CreateOrderItemRequest orderItemRequest : request.getOrderItems()) {
            var product = productRepository.findById(orderItemRequest.getProductId()).get();
            var orderItem = new OrderItem();
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setProduct(product);
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        var response = new CreateOrderResponse();
        response.setId(order.getId());
        response.setOrderAddress(order.getOrderAddress());
        response.setCustomerId(order.getCustomer().getId());
        response.setCustomerFirstName(order.getCustomer().getFirstName());

        var orderItemResponses = new ArrayList<CreateOrderItemResponse>();
        // CHECK
        for (OrderItem orderItem : order.getOrderItems()) {
            var product = orderItem.getProduct();

            var orderItemResponse = new CreateOrderItemResponse();
            orderItemResponse.setId(orderItem.getId());
            orderItemResponse.setQuantity(orderItem.getQuantity());
            orderItemResponse.setProductId(product.getId());
            orderItemResponse.setProductName(product.getName());

            orderItemResponses.add(orderItemResponse);
        }

        response.setOrderItems(orderItemResponses);

        return response;


//        for(OrderItem orderItem : order.getOrderItems()) {
////            orderItem.setQuantity(orderItem.getQuantity());
////            orderItem.setId(orderItem.getId());
////            orderItem.setProduct(orderItem.getProduct());
////            orderItem.setOrder(orderItem.getOrder());
//
////            orderItem.setOrder(order);
////            orderItem.setOrder(order);
////            orderRepository.save(order);
//
//            orderItemRepository.save(orderItem);
//        }
//
//        return orderRepository.save(order);
//---------------------------
        //OrderItem orderItem = new OrderItem();
        //orderItem.setQuantity(orderItem.getQuantity());

//-------------------------
//        List<OrderItem> orderItems = order.getOrderItems();
//
//        for (OrderItem orderItem : orderItems) {
//            orderItem.setOrder(orderItem.setQuantity());
//        }
//---------------------------
//        for (OrderItem orderItem : order.getOrderItems()) {
//            orderItem.setOrder(order);
//            //orderRepository.save(orderItem);
//            order.getOrderItems().add(orderItem);
//        }
//        return orderRepository.save(order);
//---------------------------------


//        Order savedOrder = orderRepository.save(order);
//        return savedOrder;
//
// -----------------------------------

//        Order newOrder = new Order();
//        newOrder.setOrderAddress(new String());
//
//        order.getOrderItems()
//                .forEach(orderItem -> {
//                    OrderItem orderItem1 = new OrderItem();
//                    orderItem1.setId(orderItem.getId());
//
//                    orderItem1.setOrder(newOrder);
//                    orderItem1.setQuantity(orderItem.getQuantity());
//
//                    newOrder.getOrderItems().add(orderItem);
//                });
//
//
//        return orderRepository.save(newOrder);



    }


    @Override
    public Order updateOrder(Order order) {

        Optional<Order> existingOrder =
                orderRepository.findById(order.getId());
        if(existingOrder.isEmpty()) {
            throw new RuntimeException("Cannot find the customer with id " + order.getId());
        }
        existingOrder.get().setOrderAddress(order.getOrderAddress());
        existingOrder.get().setOrderItems(order.getOrderItems());
        // products
        // existingCustomer.get().setAddresses(customer.getAddresses());
//        existingOrder.get().setProducts(order.getProducts());
        return orderRepository.save(existingOrder.get());
    }





        @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);
    }




}



