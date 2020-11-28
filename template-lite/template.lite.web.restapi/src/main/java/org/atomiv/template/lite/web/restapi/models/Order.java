package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

//@Data
@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_address")
    private String orderAddress;


//    @Column(name = "date_order")
//    private Date dateOrder;
//
//    @Column(name = "order_status")
//    private boolean orderStatus;

    // ----------------------------------------------
//    // Relationships
//    // Customer
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference(value = "customer") // stop serialization
//    private Customer customer;
//
    //----------------------------------------------------------


    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinColumn(name = "user_id", nullable = false)
    //@JsonBackReference // Customer not shown in Order
//    TODO: show customer in order
//    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;



    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    // @OrderBy("id ASC")
    private List<OrderItem> orderItems;


//    option1:
//    @OneToMany(mappedBy = "order")
//    private List<OrderItem> orderItems = new ArrayList<>();
//    option 2:
//    @OneToMany()
//    @JoinColumn(name = "order_id")
//    private List<OrderItem> orderItems = new ArrayList<>();



    public Order() {
    }

    public Order(Long id, String orderAddress, Customer customer, List<OrderItem> orderItems) {
        this.id = id;
        this.orderAddress = orderAddress;
//        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // scaffolding code
//    public void addOrderItem(OrderItem orderItem) {
//        this.orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }

//    public void addOrderItem(OrderItem orderItem) {
//        orderItems.add(orderItem);
//    }





    //    @Override
//    public String toString() {
//        return "Order [orderId=" + id + ", orderAddress=" + orderAddress  + "]";
//    }
}


// ----------------------------------------
//You can also ignore the id of LineItem by defining line items as embedded collection. For example
//
//public class Order {
//
//     @ElementCollection @OrderColumn
//     private List<LineItem> orderSegments = new ArrayList<>();
//
//}
//
//@Embeddable
//public class LineItem {
//
//     @ManyToOne
//     private Product product;
//
//     private int quantity;
//
//}