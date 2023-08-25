package com.application.examappjava.repository;

import com.application.examappjava.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
