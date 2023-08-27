package com.application.examappjava.service;

import com.application.examappjava.dto.ExperienceDto;
import com.application.examappjava.entity.Candidate;
import com.application.examappjava.entity.Experience;
import com.application.examappjava.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepo;

    public ExperienceService(ExperienceRepository experienceRepo) {
        this.experienceRepo = experienceRepo;
    }

    public Experience saveExperience(ExperienceDto experienceDto, Candidate candidate) {
        Experience experience = new Experience(experienceDto, candidate);
        return experienceRepo.save(experience);
    }
}
