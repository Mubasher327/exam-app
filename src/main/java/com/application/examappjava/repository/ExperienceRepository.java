package com.application.examappjava.repository;

import com.application.examappjava.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository <Experience, Long> {
    List<Experience> findByCandidateIdAndDeletedIsFalse(Long candidateId);
}
