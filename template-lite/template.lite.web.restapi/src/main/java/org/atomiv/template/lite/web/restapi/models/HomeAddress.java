package org.atomiv.template.lite.web.restapi.models;

import javax.persistence.*;

@Entity
public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_address_id")
    private Long id;
    private String city;

//    @ManyToOne
//    private Customer customer;

    //JC - only one references
//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;



    public HomeAddress() {
    }

    public HomeAddress(Long id, String city, Customer customer) {
        this.id = id;
        this.city = city;
//        this.customer = customer;
    }

//    public Customer getCustomer() {
////        return customer;
//    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
