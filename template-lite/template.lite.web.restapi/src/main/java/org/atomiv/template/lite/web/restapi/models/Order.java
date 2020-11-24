package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

//@Data
@Entity
@Table(name = "orders")
// TODO : needed everywhere?
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
//    // List of orderItems
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "order_item",
//            joinColumns = @JoinColumn(name = "order_item_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    @JsonManagedReference(value = "order") // stop serialization
//    private List<OrderItem> orderItems;
    //----------------------------------------------------------
//    @ManyToOne
//    private Customer customer;
    // ----------------------------------------------


    // Many Orders have One Customer ... i.e. ONE customer has MANY orders
    // @JsonManagedReference // nothing happens
    // @JsonBackReference // Customer not shown in Order
    @ManyToOne()
    @JsonIgnore // Customer not shown in Order
    @JoinColumn(name = "customer_id")
    private Customer customer;



    // ONE order has Many orderItems
    // TODO i had this originally
    // why doesn't mappedBy "orders" work???
    @OneToMany(mappedBy = "order")
//    // @OrderBy("id ASC")
    private List<OrderItem> orderItems = new ArrayList<>();
//    private List<OrderItem> orderItems = new ArrayList<OrderItem>();


    // TODO JC - does this stop the loop??
//    @ManyToMany(mappedBy = "orders")
//    @JsonIgnore
//    private Customer customer;



    // TODO will this work?
//    @ManyToMany(mappedBy = "addresses")
//    @JsonIgnore
//    private List<Customer> customers;


    // @OneToMany(cascade=CascadeType.ALL, mappedBy="customOrder")
    // @OneToMany(mappedBy = "order")
    // @OneToMany(cascade = CascadeType.ALL)
    //private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    // private List<OrderItem> orderItems = new ArrayList<>();

    // private List<OrderItem> orderItems;
    // List OR Set
    //private Set<OrderItem> orderItems;
    // private Set<Item> items = new HashSet<Item>();

    // ------------------------------------
    // TODO
//    @ManyToOne
//    @JoinColumn
//    private Customer customer;

    // -----------------------------------------------------------
    //Повар
//    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
//    @JsonBackReference(value = "cook") // Таким образом я предотвратил рекурсию
//    private Cook cook;


    public Order() {
    }

//    public Order(Long id, String orderAddress, Customer customer) {
//        this.id = id;
//        this.orderAddress = orderAddress;
//        this.customer = customer;
//    }


    public Order(Long id, String orderAddress, Customer customer, List<OrderItem> orderItems) {
        this.id = id;
        this.orderAddress = orderAddress;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

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