package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
