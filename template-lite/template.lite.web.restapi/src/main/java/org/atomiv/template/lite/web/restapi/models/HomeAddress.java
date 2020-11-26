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

    public HomeAddress() {
    }

    public HomeAddress(Long id, String city) {
        this.id = id;
        this.city = city;
    }


//    public Customer getCustomer() {
//        return customer;
//    }
//
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