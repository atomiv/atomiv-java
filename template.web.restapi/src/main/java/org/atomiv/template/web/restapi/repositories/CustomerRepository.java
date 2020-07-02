package org.atomiv.template.web.restapi.repositories;

import org.atomiv.template.web.restapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
