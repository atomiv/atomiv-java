package org.atomiv.template.lite.web.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;


    //private String street;
    private String city;




    @ManyToOne()
    // i think it only started doing the id properly and showing up in pgAdmin after @MapsId
    @MapsId("customer_id")
//    @JoinColumn("customer_id")
    private Customer customer;





    public Address(Long id, String city, Customer customer) {
        this.id = id;
        this.city = city;
        this.customer = customer;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
