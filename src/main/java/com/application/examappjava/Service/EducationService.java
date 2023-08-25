package com.application.examappjava.service;

import com.application.examappjava.dto.EducationDto;
import com.application.examappjava.entity.Education;
import com.application.examappjava.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }


    public void addEducation(EducationDto educationDto) {
        Education education=new Education(educationDto);
        educationRepository.save(education);

    }

    public EducationDto getEducationByID(Long id) {
        return educationRepository.findById(id)
                .map(EducationDto::new)
                .orElse(null);
    }

    public List<EducationDto> getEducationList() {
        return educationRepository.findAll().stream().map(EducationDto::new).collect(Collectors.toList());
    }

    public boolean deleteEducationByID(Long id) {
        if (educationRepository.existsById(id)) {
            educationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateEducation(Long id, EducationDto updatedEducation) {
        Education existingEducation = educationRepository.findById(id).orElse(null);

        if (existingEducation != null) {
            existingEducation.updateFromDto(updatedEducation);
            educationRepository.save(existingEducation);
            return true;
        } else {
            return false;
        }
    }
}
