package org.atomiv.template.lite.web.restapi.controllers;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


import javax.validation.Valid;

import org.atomiv.template.lite.web.restapi.exception.ResourceNotFoundException;

import org.atomiv.template.lite.web.restapi.models.Order;
import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.atomiv.template.lite.web.restapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class OrderController {

	ConcurrentMap<String, OrderItem> orderItems = new ConcurrentHashMap<>();

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();

	}

	@PostMapping("/orders")
	public Order createOrder(@Valid Order order) {
		return orderRepository.save(order);

	}

	@GetMapping("/orders/{id}/existing")
	public ResponseEntity<Order> getExistingOrderById(@PathVariable(value = "id") long orderId)
			throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException(" Order not found for this id: " + orderId));
		return ResponseEntity.ok().body(order);
	}

	@GetMapping("/orders{id}/docs")
	@ApiOperation(value = "Find OrderItem by id", notes = "Provide an id to look specific OrderItem form the Order", response = OrderItem.class)
	public OrderItem getOrderItem(
			@ApiParam(value = "ID value for the OrderItem you need to retrieve, required = true") @PathVariable long id) {
		return orderItems.get(id);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateExistingOrder(@PathVariable(value = "id") long orderId,
			@RequestBody Order orderDetails) throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException(" Order not found for this id: " + orderId));
		order.setOrderDate(orderDetails.getOrderDate());
		orderRepository.save(order);
		return ResponseEntity.ok().body(order);

	}

}
