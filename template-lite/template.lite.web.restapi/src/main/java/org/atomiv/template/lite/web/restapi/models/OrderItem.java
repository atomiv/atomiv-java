package org.atomiv.template.lite.web.restapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "orderItems")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "ProductId cannot be null")
	private long productId;
	private double unitPrice;
	@Min(1)
	private int quantity;
	
	public OrderItem() {
		
	}

	public OrderItem(long id, long productId, double unitPrice, int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	
	

}
