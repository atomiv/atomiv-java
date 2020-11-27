package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Order;
import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.atomiv.template.lite.web.restapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


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
    public Order createOrder(Order order) {
    //        for (OrderItem orderItem : order.getOrderItems()) {
        //            orderItem.setOrder(order);
        //        }
        //-------------------------------
//        for (OrderItem orderItem : order.getOrderItems()) {
////            orderItem.setOrder(order);
//
//            order.getOrderItems().add(orderItem);
//        }
        //orderItems.add(orderItem);
        //order.addOrderItem(orderItem);

        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.setOrder(order);
        }

          return orderRepository.save(order);

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



