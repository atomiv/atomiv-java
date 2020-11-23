package org.atomiv.template.lite.web.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    // necessary? line below
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Long id;

    private Integer quantity;

    //@ManyToOne(cascade = CascadeType.ALL)
    //private CustomOrder customOrder;
    @ManyToOne
    @JoinColumn(name = "order_id") // is @JoinColumn needed? ... name = "order_id" ... name="id"
    private Order order;



    public OrderItem() {
    }

    public OrderItem(Long id, Integer quantity, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //@Override
    //	public String toString() {
    //		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", quantity=" + quantity
    //				+ ", oid=" + oid + "]";
    //	}
}
