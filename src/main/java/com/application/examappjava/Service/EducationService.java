package com.application.examappjava.service;

import com.application.examappjava.dto.EducationDto;
import com.application.examappjava.entity.Candidate;
import com.application.examappjava.entity.Education;
import com.application.examappjava.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    
    private final EducationRepository educationRepo;

    public EducationService(EducationRepository educationRepo) {
        this.educationRepo = educationRepo;
    }


    public Education saveEducation(EducationDto educationDto, Candidate candidate) {
        Education education = new Education(educationDto, candidate);
        return educationRepo.save(education);
    }
}
