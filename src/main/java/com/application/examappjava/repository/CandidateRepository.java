package com.application.examappjava.repository;

import com.application.examappjava.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository <Candidate, Long> {
    Candidate findByIdAndDeletedIsFalse(Long candidateId);

    List<Candidate> findAllByDeletedIsFalse();
}
