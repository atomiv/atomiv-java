package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity//(name = "HomeAddress")
@Table(name = "home_address")
@Data
public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_address_id")
    private Long id;

    private String city;


    //The best way to map a @OneToOne relationship is to use @MapsId. This way, you don’t even need a bidirectional association since you can always fetch the PostDetails entity by using the Post entity identifier.

//    @OneToOne(fetch = FetchType.LAZY)
////    @MapsId
//    //If you want to customize the Primary Key column name when using @MapsId, you need to use the @JoinColumn annotation.
//    // @JoinColumn(name = "address_id", referencedColumnName = "id")
//    @JoinColumn(name = "customer_id")
//    private Customer customer;



//    @ManyToOne(optional = false)
////    @MapsId("customer_id") //generated id... @MapsId //
//    @JoinColumn(name = "customer_id")
//    private Customer customer;


    //To declare a side as not responsible for the relationship, the attribute mappedBy is used. ‘mappedBy’ refers to the property name of the association on the owner side.
//    @OneToOne(mappedBy = "homeAddress")
//    private Customer customer;

    //optional=false
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "idStock", nullable = false)
    //private Stock stock;

    @OneToOne(fetch = FetchType.LAZY)// added fetch
//    @MapsId // don't know if this is stuffing up with the order being null when i GET,
//    the column with the homeAddress id is not being created. yes, it was only creating the customerId column.
    @JoinColumn(name = "customer_id", updatable = false)
    private Customer customer;



    public HomeAddress() {
    }

}
