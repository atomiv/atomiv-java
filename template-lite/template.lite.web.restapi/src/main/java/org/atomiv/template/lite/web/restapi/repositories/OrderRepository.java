package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
