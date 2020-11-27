package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Customer
 */
@Entity//(name = "Customers")
@Table(name = "customers")
// prevent serialization error when GET sessions/2 in postman
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
///implements Serializable
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message = "Please fill in the customer name.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    //private final Set<Address> addresses = new HashSet<Address>();
    @OneToMany(mappedBy = "customer", targetEntity = Address.class, cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "address_id")
//    @PrimaryKeyJoinColumn //?
    private List<Address> addresses;

//    @OneToMany
//    @JoinTable(name = "cust_address",
//    joinColumns = {@JoinColumn(name = "customer_id")},
//    inverseJoinColumns = {@JoinColumn(name = "address_id")})
//
//    private List<Address> addresses;


//    @ManyToOne(fetch=FetchType.EAGER, optional=true, cascade=CascadeType.ALL)
//    @JoinColumn(name = "home_address_id")//fk_home_address
//    @ManyToOne(cascade=CascadeType.ALL)
//    private HomeAddress homeAddress;

    //However, this mapping is not the most efficient, as further demonstrated.
    //he post_details Primary Key is also a Foreign Key, and the two tables are sharing their PKs as well
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//    @JoinColumn//(name = "home_address_id")
//    private HomeAddress homeAddress;




    // Relationships -----------------------------------------

    // have this for orders. cascade = CascadeType.ALL
    // have it as NONE
    // TODO JC
    // @JsonIgnore // orders not shown for customer
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;



    // TODO works jelena
//    @OneToMany
//    @JoinTable(
//            name = "customer_orders",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id")
//    )
//    private List<Order> orders;



    // java-demo
//    @ManyToMany (mappedBy = "customers")
//    @JsonIgnore
//    private List<Order> orders;



//    @Column(name = "email_address", nullable = false)
//    private String email;
//
//    @Column(name = "created_at", nullable = false)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column(name = "created_by", nullable = false)
//    @CreatedBy // @LastModifiedDate updatedAt, @LastModifiedBy updatedBy
//    private String createdBy;


    public Customer() {
    }



    public Customer(Long id, @NotEmpty(message = "Please fill in the customer name.") String firstName, String lastName, List<Address> addresses, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }


    //And always call addEmailAddress() to add an email for a customer. You can apply the same idea for updating an email address for a customer.
    private void addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
    }

//    public HomeAddress getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(HomeAddress homeAddress) {
//        this.homeAddress = homeAddress;
//    }

    public Customer(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    //    public void addAddress(Address address) {
//        address.setCustomer(this);
//        this.addresses.add(address);
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // I suggest you make use of your IDE's features to generate the toString method. Don't hand-code it
    // This is not good practice ,as you are using string concatenation
    // StringBuilder is a better choice in such a situation
    // TODO what is the purpose of this
    @Override
    public String toString() {
        return "Customer {" +
                "id = " + id +
                ", name = " + firstName + '\'' +
                ", last name = " + lastName +
                " }";
    }


//    @Override
//    public String toString() {
//        return String.format(
//                "Customer[id=%s, firstName='%s', lastName='%s']",
//                id, firstName, lastName);
//    }

    // ----------------------------------------------
//    @Override
//    public String toString() {
//        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
//    }

    // Override toString() method java

    // If you need to call the method from the super class, then you need to do it by yourself by calling super.toString().

// -----------------------------------------

//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("First name : ").append(this.firstName).append("\n");
//        sb.append("Last name : ").append(this.lastName).append("\n");
//        sb.append("Email : ").append(this.email).append("\n");
//        return sb.toString();
//    }
//
//    public static void main(String args[]) {
//        ToStringExample example = new ToStringExample();
//        example.setFirstName("Testing");
//        example.setLastName("Tester");
//        example.setEmail("testing@tester.com");
//
//        System.out.println(example);
//    }


}
