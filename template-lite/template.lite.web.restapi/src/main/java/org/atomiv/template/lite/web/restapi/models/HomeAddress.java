package org.atomiv.template.lite.web.restapi.models;

import javax.persistence.*;

@Entity//(name = "HomeAddress")
@Table(name = "home_address")

public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_address_id")
    private Long id;

    private String city;


    //Most often, this relationship is mapped as follows:
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
    //The best way to map a @OneToOne relationship is to use @MapsId. This way, you don’t even need a bidirectional association since you can always fetch the PostDetails entity by using the Post entity identifier.

//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Customer customer;


    public HomeAddress() {
    }

    public HomeAddress(Long id, String city, Customer customer) {
        this.id = id;
        this.city = city;
//        this.customer = customer;
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
