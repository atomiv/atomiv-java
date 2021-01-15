package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    //private String street;
    private String city;



//    @ManyToOne(cascade = CascadeType.ALL) - Cascade not needed
    //@ManyToOne(optional = false, fetch = FetchType.LAZY)//JC
    @ManyToOne()
//    @MapsId("customer_id") //generated id... @MapsId //
    //  @JoinColumn(name = "customer_id", nullable = false // later
    // @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    @JoinColumn(name = "customer_id", insertable = true, updatable = false)
    private Customer customer;


    public Address() {
    }

}
