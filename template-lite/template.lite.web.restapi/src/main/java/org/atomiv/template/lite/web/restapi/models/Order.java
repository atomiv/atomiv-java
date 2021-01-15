package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
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

    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinColumn(name = "user_id", nullable = false)



    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "order_id", referencedColumnName = "customer_id", insertable=false, updatable=false)
// Key (order_id)=(3) is not present in table "customers". //for order=1, puts in customer=1, ord=2 puts in automatically ord=2... if customer=3 doesn't exist can't create ord=3
    @JoinColumn(name = "customer_id")
    private Customer customer;



    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    private List<OrderItem> orderItems;



//    @OneToMany()
//    @JoinColumn(name = "order_id")
//    private List<OrderItem> orderItems = new ArrayList<>();



    public Order() {
    }



    @Override
    public String toString() {
        return "Order [orderId=" + id + ", orderNo=" + orderAddress  + "]";
        // customer_id
        // orderItems
    }




    // scaffolding code
//    public void addOrderItem(OrderItem orderItem) {
//        this.orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }

//    public void addOrderItem(OrderItem orderItem) {
//        orderItems.add(orderItem);
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