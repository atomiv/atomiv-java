package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Customer
 */
@Entity
@Table(name = "customers")
// prevent serialization error when GET sessions/2 in postman
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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



    //@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    //private final Set<Address> addresses = new HashSet<Address>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)//(mappedBy = "customer")
    //@JoinColumn(name = "address_id")
    private List<Address> addresses;





    // maybe shippingAddress. User + Address
//    @ManyToOne(fetch=FetchType.EAGER, optional=true, cascade=CascadeType.ALL)
//    @JoinColumn(name = "home_address_id")//fk_home_address
//    @ManyToOne(cascade=CascadeType.ALL)
//    private HomeAddress homeAddress;




    // Relationships -----------------------------------------

    // have this for orders. cascade = CascadeType.ALL
    // have it as NONE
    // TODO JC
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Order> orderList;

    // TODO why is this not working?
    //@JsonBackReference
    // @JsonIgnore // orders not shown for customer


    @OneToMany(mappedBy = "customer")
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



    //    public Customer(Long id, String firstName, String lastName) {
//        // TODO - why super()
//        super();
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }



    public Customer(Long id, @NotEmpty(message = "Please fill in the customer name.") String firstName, String lastName, List<Address> addresses, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
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
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        String requestUrl = request.getRequestURI();
//        String name = requestUrl.substring("/people/".length());
//
//        Person person = DataStore.getInstance().getPerson(name);
//
//        if(person != null){
//            String json = "{\n";
//            json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
//            json += "\"about\": " + JSONObject.quote(person.getAbout()) + ",\n";
//            json += "\"birthYear\": " + person.getBirthYear() + "\n";
//            json += "}";
//            response.getOutputStream().println(json);
//        }
//        else{
//            //That person wasn't found, so return an empty JSON object. We could also return an error.
//            response.getOutputStream().println("{}");
//        }
//    }

//    --------------------------------------------------------

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




//    The above code outputs the following:
//
//    First name : Testing
//    Last name : Tester
//    Email : testing@tester.com
//
//    If we didn’t override the toString() method, the output would have been
//
//    io.devqa.tutorials.ToStringExample@60e53b93

//
// -----------------------------------------------------
}
