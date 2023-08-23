package com.application.examappjava.Repository;

import com.application.examappjava.Entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository <Candidate,Long> {
}
