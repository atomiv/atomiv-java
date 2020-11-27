package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

//    //, cascade = CascadeType.ALL
//    @OneToOne(fetch = FetchType.LAZY)
////    @MapsId
//    //If you want to customize the Primary Key column name when using @MapsId, you need to use the @JoinColumn annotation.
//    //If you want to customize the Primary Key column name when using @MapsId, you need to use the @JoinColumn annotation.
//    // @JoinColumn(name = "address_id", referencedColumnName = "id")
//    @JoinColumn(name = "customer_id")
//    private Customer customer;



//TODO
    //  @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
//        mappedBy = "userProfile")
//    private User user;


//    @JsonBackReference
//    @ManyToOne(optional = false)
////    @MapsId("customer_id") //generated id... @MapsId //
//    @JoinColumn(name = "customer_id")
//    private Customer customer;


    //To declare a side as not responsible for the relationship, the attribute mappedBy is used. ‘mappedBy’ refers to the property name of the association on the owner side.
//    @OneToOne(mappedBy = "homeAddress")
//    private Customer customer;
    // not sure why the above wasn't working

    //optional=false
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "idStock", nullable = false)
    //private Stock stock;
    @JsonBackReference
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;



    public HomeAddress() {
    }

    public HomeAddress(Long id, String city, Customer customer) {
        this.id = id;
        this.city = city;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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
}
