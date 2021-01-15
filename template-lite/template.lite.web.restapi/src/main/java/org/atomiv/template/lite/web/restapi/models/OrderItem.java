package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private Integer quantity;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()// TODO: cascade = CascadeType.ALL, optional = false
    @JoinColumn(name = "order_id", updatable = false)
    private Order order;



    @ManyToOne()//optional = false // doesn't work if cascade.. cascade = CascadeType.ALL
    //referenced column = id
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")//--> replace @JoinColumn with @MapsId
    private Product product;



    public OrderItem() {
    }


    //@Override
    //	public String toString() {
    //		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", quantity=" + quantity
    //				+ ", oid=" + oid + "]";
    //	}
}
