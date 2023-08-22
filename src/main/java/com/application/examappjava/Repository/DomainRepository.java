package com.application.examappjava.Repository;

import com.application.examappjava.Entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain,Long > {
}
