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
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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



//    @JsonBackReference // Customer not shown in Order
////    TODO: show customer in order
    //TODO: testing, removed below... CascadeType.ALL, optional = false
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")

//    @JoinColumn(name = "order_id", referencedColumnName = "customer_id", insertable=false, updatable=false)
//
// Key (order_id)=(3) is not present in table "customers". //for order=1, puts in customer=1, ord=2 puts in automatically ord=2... if customer=3 doesn't exist can't create ord=3
    @JoinColumn(name = "customer_id")

    // IMPL??? done in CustomerServiceImpl
    private Customer customer;







    // TODO: Simple
    //@JsonBackReference // needed otherwise there's an error.
    //cascade = CascadeType.ALL, optional = false
    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne()
    @JoinColumn(name = "simple_id")
    private Simple simple;






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

    public Order(Long id, String orderAddress, Customer customer, Simple simple, List<OrderItem> orderItems) {
        this.id = id;
        this.orderAddress = orderAddress;
        this.customer = customer;
        this.simple = simple;
        this.orderItems = orderItems;
    }

    public Simple getSimple() {
        return simple;
    }

    public void setSimple(Simple simple) {
        this.simple = simple;
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