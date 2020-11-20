package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.dto.CustomerDto;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
