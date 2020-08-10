package org.atomiv.template.infrastructure.repositories.jpa;

import java.util.UUID;

import org.atomiv.template.infrastructure.persistence.jpa.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerRecord, UUID> {

}
