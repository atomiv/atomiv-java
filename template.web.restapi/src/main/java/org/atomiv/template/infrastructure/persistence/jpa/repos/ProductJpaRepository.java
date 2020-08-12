package org.atomiv.template.infrastructure.persistence.jpa.repos;

import java.util.UUID;

import org.atomiv.template.infrastructure.persistence.jpa.records.ProductRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductRecord, UUID> {

}
