package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    //private String street;
    private String city;



//    @ManyToOne(cascade = CascadeType.ALL) - Cascade not needed
    @JsonBackReference
    //@ManyToOne(optional = false, fetch = FetchType.LAZY)//JC
    @ManyToOne()
//    @MapsId("customer_id") //generated id... @MapsId //
    //  @JoinColumn(name = "customer_id", nullable = false // later
    @JoinColumn(name = "customer_id")// added because customer id 2 columns
    private Customer customer;


    public Address() {
    }

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
