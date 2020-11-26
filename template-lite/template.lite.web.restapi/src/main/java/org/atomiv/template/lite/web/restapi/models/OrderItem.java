package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order_items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderItem implements Serializable {
    @Id
    // necessary? line below
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private Integer quantity;

    //@ManyToOne(cascade = CascadeType.ALL)
    //private CustomOrder customOrder;
    //@JsonBackReference // needed otherwise there's an error. NOT ANYMORE??
    @ManyToOne(cascade = CascadeType.ALL)
    // is the line below even necessary?? yes, or order items don't show
    @JoinColumn(name = "order_id")
    private Order order;

    //@ManyToOne(fetch = FetchType.LAZY)
    //    @JoinColumn(name = "fk_order")
    //    private PurchaseOrder order;



//    @ManyToOne
////    @JoinColumn(name = "product_id")
//    @JoinTable(
//            name = "order_item_products",
//            joinColumns = @JoinColumn(name = "order_item_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
////    private List<Product> products;
//    private Product product;

    @OneToOne()
    @JoinColumn(name = "product_id")
    private Product product;



    public OrderItem() {

        super();
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

    //    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    //@Override
    //	public String toString() {
    //		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", quantity=" + quantity
    //				+ ", oid=" + oid + "]";
    //	}
}
