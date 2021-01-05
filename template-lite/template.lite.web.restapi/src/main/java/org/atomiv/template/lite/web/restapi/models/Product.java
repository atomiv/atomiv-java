package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;



    // TODO: if it's unidirectional @OneToMany ???
    // Product + OrderItem
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<OrderItem> orderItems;



    public Product() {
    }

    public Product(Long id, String name, List<OrderItem> orderItems) {
        this.id = id;
        this.name = name;
//        this.orderItems = orderItems;
    }

//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }


}
