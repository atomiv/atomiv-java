package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "products")
////    @JsonIgnore
//    //private List<Order> orders;
//    private OrderItem orderItem;

//    //TODO delete block of code above
//    // TODO products table shouldn't have "order_item_id" column
//    //@JsonBackReference
//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_item_id")
//    private OrderItem orderItem;







    public Product() {
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
