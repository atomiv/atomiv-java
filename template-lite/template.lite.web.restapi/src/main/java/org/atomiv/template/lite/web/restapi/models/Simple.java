package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * The type Simple
 */
@Entity//(name = "Simples")
@Table(name = "simples")
// prevent serialization error when GET sessions/2 in postman
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Simple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simple_id")
    private Long id;

    @NotEmpty(message = "Please fill in the simple name.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;



    //private final Set<Address> addresses = new HashSet<Address>();
//    @OneToMany(mappedBy = "simple", targetEntity = Address.class, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Address> addresses;



    // Relationships -----------------------------------------

    // TODO: show simple in order
    @JsonBackReference // not show orders in Simple, but show simple in orders
//    @OneToMany(mappedBy = "simple", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "simple")
    private List<Order> orders;





    // cascade = CascadeType.ALL
//    @OneToOne(mappedBy = "simple", cascade = CascadeType.ALL)
//    private HomeAddress homeAddress;



    public Simple() {
    }

    public Simple(Long id, @NotEmpty(message = "Please fill in the simple name.") String firstName, String lastName, List<Address> addresses, List<Order> orders, HomeAddress homeAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.addresses = addresses;
        this.orders = orders;
//        this.homeAddress = homeAddress;
    }

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

//    public List<Address> getAddresses() {
//        return addresses;
//    }

//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

//    public HomeAddress getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(HomeAddress homeAddress) {
//        this.homeAddress = homeAddress;
//    }





    // I suggest you make use of your IDE's features to generate the toString method. Don't hand-code it
    // This is not good practice ,as you are using string concatenation
    // StringBuilder is a better choice in such a situation
    // TODO what is the purpose of this
    @Override
    public String toString() {
        return "Simple {" +
                "id = " + id +
                ", name = " + firstName + '\'' +
                ", last name = " + lastName +
                " }";
    }



}
