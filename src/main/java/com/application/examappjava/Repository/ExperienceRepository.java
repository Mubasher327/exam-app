package com.application.examappjava.Repository;

import com.application.examappjava.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository <Experience,Long> {
}
