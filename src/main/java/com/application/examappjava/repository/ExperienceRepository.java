package com.application.examappjava.repository;

import com.application.examappjava.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository <Experience,Long> {
}
