package com.application.examappjava.repository;

import com.application.examappjava.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByCandidateIdAndDeletedIsFalse(Long candidateId);
}
