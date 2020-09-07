package org.atomiv.template.lite.web.restapi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.atomiv.template.lite.web.restapi.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "CustomerId cannot be null")
	private long customerId;
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	@OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "oi_fk", referencedColumnName = "id")
	private List<OrderItem> orderItems;

	public Order() {

	}

	public Order(long id, long customerId, Date orderDate, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderDate = orderDate;
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

	public List<OrderItem> getOrderItem() {
		return orderItems;
	}

	public void setOrderItem(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
