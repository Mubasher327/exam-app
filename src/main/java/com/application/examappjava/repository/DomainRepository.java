package com.application.examappjava.repository;

import com.application.examappjava.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain,Long > {
}
