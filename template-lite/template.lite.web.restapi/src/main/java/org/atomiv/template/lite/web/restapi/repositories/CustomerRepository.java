package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Customer Repository
 */
// JPA Data Repository Layer or CRUD
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public List<Customer> findByFirstName(String firstName);
}
