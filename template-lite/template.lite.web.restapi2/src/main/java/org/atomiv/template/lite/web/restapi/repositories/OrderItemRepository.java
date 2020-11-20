package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
