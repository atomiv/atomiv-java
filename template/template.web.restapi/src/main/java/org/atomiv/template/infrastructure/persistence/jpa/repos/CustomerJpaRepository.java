package org.atomiv.template.infrastructure.persistence.jpa.repos;

import java.util.UUID;

import org.atomiv.template.infrastructure.persistence.jpa.records.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerRecord, UUID> {

}
