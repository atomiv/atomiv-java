package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Customer Repository
 */
// JPA Data Repository Layer
// TODO should it be annotated with @Repository extends JpaRepository
// is @Repository needed
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // List<Customer_Orders> findAllByFirstName(String customer_first_name);
    public List<Customer> findByFirstName(String firstName);
}
