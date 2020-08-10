package org.atomiv.template.infrastructure.repositories.jpa;

import org.atomiv.template.infrastructure.persistence.jpa.ProductRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductRecord, Long> {

}
