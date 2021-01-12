package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order_items")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private Integer quantity;

    // Order + OrderItem -----------------
    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()// TODO: JC. issues with UPDATE. cascade = CascadeType.ALL, optional = false
    @JoinColumn(name = "order_id")
    private Order order;



    //    TODO: if it's unidirectional @OneToMany ???
    @ManyToOne()//TODO issues with UPDATE.. optional = false  PUT IT BACK //optional is not necessary. doesn't work if cascade.. cascade = CascadeType.ALL
    //referenced column = id
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")//--> replace @JoinColumn with @MapsId
    private Product product;






    public OrderItem() {
    }

    public OrderItem(Long id, Integer quantity, Order order, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    //@Override
    //	public String toString() {
    //		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", quantity=" + quantity
    //				+ ", oid=" + oid + "]";
    //	}
}
