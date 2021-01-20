package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * The type Customer
 */
//@Entity public class CustomerOrder implements Serializable {
@Entity//(name = "Customers")
@Table(name = "customers")
@Data
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

//    Address shippingAddress;
//    Address billingAddress;

//    @OrderBy("title ASC")

//@Column(name = "id", updatable = false, nullable = false)

//    @Column(name = "name")
//    @Email(message = "*Please provide a valid tag")
//    @NotEmpty(message = "*Please provide an tag")
//    private String name;

//    @Column(name = "name")
//    @NotNull
//    private String name;

//private BillingAddress billingAddress;

//    @NotEmpty (message = "  The username must not be blank.")
//    private String username;
//
//    @NotEmpty (message = "  The password must not be blank.")
//    private String password;
//    private boolean enabled;



//    @OneToMany(mappedBy = "customer", targetEntity = Address.class, cascade = CascadeType.ALL, orphanRemoval = true)
    //Unidirectional association with one-to-many
//    , orphanRemoval = true ?// issues
    // added mappedBy, fetch and orphanRemoval
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id") // removed this, added mappedBy above for bidirectional. Added referencedColumnName so  customer_customer_d isn't created on top of customer_id in teh Addresses table
//    @OneToMany(fetch = FetchType.EAGER, mappedBy="customer", cascade=CascadeType.ALL)
    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")// necessary???
    private List<Address> addresses;
    */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval=true)
    @OrderBy("id") // add everywhere
    private List<Address> addresses;


    // Implementing with a Shared Primary Key in JPA
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)// added fetch and lazy
//    @JoinColumn(name = "home_address_id")
    @PrimaryKeyJoinColumn
    private HomeAddress homeAddress;




    //@JsonBackReference // not show orders in Customer, but show customer in orders
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;




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

    // for orphan removal??
    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
    }



    //    public void addAddress(Address address) {
//        address.setCustomer(this);
//        this.addresses.add(address);
//    }

/*
public void addCustomer(String name) {
        Customer c = new Customer();
        c.name = name;
        repo.save(c);
    }
 */


    // I suggest you make use of your IDE's features to generate the toString method. Don't hand-code it
    // This is not good practice ,as you are using string concatenation
    // StringBuilder is a better choice in such a situation
    // TODO what is the purpose of this
    // to prevent the error when debugging: Method threw 'java.lang.StackOverflow' exception. Cannot evaluate org.atomiv.template.lite.web.restapi.models.Customer.toString() .. also HomeAddress.toString()
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
