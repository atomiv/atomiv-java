package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.dtos.order.*;
import org.atomiv.template.lite.web.restapi.dtos.order_item.*;
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
    public GetAllOrdersResponse getAllOrders() {

        // List<Tutorial> tutorials = tutorialRepository.findAll(Sort.by(orders));
//        return (List<Order>) orderRepository.findAll();

        var orders = (List<Order>) orderRepository.findAll();

        var records = new ArrayList<GetAllOrdersRecordResponse>();


        for(Order order : orders) {
            var record = new GetAllOrdersRecordResponse();
            record.setId(order.getId());
            record.setOrderAddress(order.getOrderAddress());
            record.setCustomerId(order.getCustomer().getId());
            record.setCustomerFirstName(order.getCustomer().getFirstName());


            var orderItemRecords = new ArrayList<GetAllOrderItemsRecordResponse>();

            for (OrderItem orderItem : order.getOrderItems()) {
                var product = orderItem.getProduct();
                var orderItemRecord = new GetAllOrderItemsRecordResponse();

                orderItemRecord.setId(orderItem.getId());
                orderItemRecord.setQuantity(orderItem.getQuantity());
                orderItemRecord.setProductId(product.getId());
                orderItemRecord.setProductName(product.getName());
                orderItemRecords.add(orderItemRecord);
            }
            record.setOrderItems(orderItemRecords);

            records.add(record);
        }

        var response = new GetAllOrdersResponse();
        response.setRecords(records);


        return response;
    }


    @Override
    public GetOrderResponse getOrderById(long id) {

        Optional<Order> optionalOrder = orderRepository.findById(id);

//        if(optionalOrder.isEmpty()) {
//            throw new OrderNotFoundException("Order not found");
//        }

        var order = optionalOrder.get();

        var customer= order.getCustomer();


        var response = new GetOrderResponse();
        response.setId(order.getId());
        response.setOrderAddress(order.getOrderAddress());
        response.setCustomerId(customer.getId());
        response.setCustomerFirstName(customer.getFirstName());

        var orderItemResponses = new ArrayList<GetOrderItemResponse>();
        for (OrderItem orderItem : order.getOrderItems()) {
            var product = orderItem.getProduct();
            var orderItemResponse = new GetOrderItemResponse();

            orderItemResponse.setId(orderItem.getId());
            orderItemResponse.setQuantity(orderItem.getQuantity());
            orderItemResponse.setProductId(product.getId());
            orderItemResponse.setProductName(product.getName());
            orderItemResponses.add(orderItemResponse);
        }
        response.setOrderItems(orderItemResponses);


        return response;

    }


    @Override
    public GetOrdersByCustomerIdResponse getOrdersByCustomerId(long customerId) {

        var orders = orderRepository.findByCustomerId(customerId);

        var records = new ArrayList<GetOrdersByCustomerIdRecordResponse>();


        for(Order order : orders) {
            var record = new GetOrdersByCustomerIdRecordResponse();
            record.setId(order.getId());
            record.setOrderAddress(order.getOrderAddress());

            var orderItemResponses = new ArrayList<GetAllOrderItemsRecordResponse>();
            for (OrderItem orderItem : order.getOrderItems()) {
                var product = orderItem.getProduct();
                var orderItemResponse = new GetAllOrderItemsRecordResponse();

                orderItemResponse.setId(orderItem.getId());
                orderItemResponse.setQuantity(orderItem.getQuantity());
                orderItemResponse.setProductId(product.getId());
                orderItemResponse.setProductName(product.getName());
                orderItemResponses.add(orderItemResponse);
            }
            record.setOrderItems(orderItemResponses);
            records.add(record);
        }

        var response = new GetOrdersByCustomerIdResponse();
        response.setRecords(records);

        return response;

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

    }


    @Override
    public UpdateOrderResponse updateOrder(UpdateOrderRequest request) {

        var id = request.getId();
        var optionalOrder = orderRepository.findById(id);

//        if(optionalOrder.isEmpty()) {
//            throw new OrderNotFoundException("Order not found");
//        }

        var order = optionalOrder.get();
        order.setOrderAddress(request.getOrderAddress());
//        order.setCustomer();

        var orderItems = new ArrayList<OrderItem>();
        for (UpdateOrderItemRequest orderItemRequest : request.getOrderItems()) {
            var orderItem = new OrderItem();
//            var product = orderItem.getProduct();
            var product = productRepository.findById(orderItemRequest.getProductId()).get();

            orderItem.setId(orderItemRequest.getId());
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setProduct(product);
            orderItem.setOrder(order);
            orderItems.add(orderItem);
            order.getOrderItems().clear();
        }
        order.getOrderItems().addAll(orderItems);

        orderRepository.save(order);

        var response = new UpdateOrderResponse();
        response.setId(order.getId());
        response.setOrderAddress(order.getOrderAddress());
        response.setCustomerId(order.getCustomer().getId());
        response.setCustomerFirstName(order.getCustomer().getFirstName());

        var orderItemResponses = new ArrayList<UpdateOrderItemResponse>();
        for (OrderItem orderItem : order.getOrderItems()) {
            var product = orderItem.getProduct();
            var orderItemResponse = new UpdateOrderItemResponse();
            orderItemResponse.setId(orderItem.getId());
            orderItemResponse.setQuantity(orderItem.getQuantity());
            orderItemResponse.setProductId(product.getId());
            orderItemResponse.setProductName(product.getName());
            orderItemResponses.add(orderItemResponse);
        }
        response.setOrderItems(orderItemResponses);

        return response;
    }




        @Override
    public void deleteOrderById(long id) {

        orderRepository.deleteById(id);
    }



}



