package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.models.Simple;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Customer Repository
 */
// JPA Data Repository Layer or CRUD
@Repository
public interface SimpleRepository extends CrudRepository<Simple, Long> {
}
