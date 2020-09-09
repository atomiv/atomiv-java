package org.atomiv.template.lite.web.restapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.atomiv.template.lite.web.restapi.enums.OrderStatus;
import org.atomiv.template.lite.web.restapi.models.OrderItem;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private long customerId;
	private Date orderDate;
	private OrderStatus orderStatus;
	private List<OrderItem> orderItems;

	public OrderDto() {

	}

	public OrderDto(long id, long customerId, Date orderDate, OrderStatus orderStatus, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
