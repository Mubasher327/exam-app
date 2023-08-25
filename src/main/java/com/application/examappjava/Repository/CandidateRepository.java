package com.application.examappjava.repository;

import com.application.examappjava.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository <Candidate,Long> {
}
