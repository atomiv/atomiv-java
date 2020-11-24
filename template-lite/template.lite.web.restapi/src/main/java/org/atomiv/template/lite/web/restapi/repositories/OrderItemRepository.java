package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
