package com.application.examappjava.service;

import com.application.examappjava.dto.ExperienceDto;
import com.application.examappjava.entity.Experience;
import com.application.examappjava.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }


    public void addExperience(ExperienceDto experienceDto) {
        Experience experience=new Experience(experienceDto);
        experienceRepository.save(experience);

    }

    public ExperienceDto getExperienceByID(Long id) {
        return experienceRepository.findById(id)
                .map(ExperienceDto::new)
                .orElse(null);
    }

    public List<ExperienceDto> getExperienceList() {
        return experienceRepository.findAll().stream().map(ExperienceDto::new).collect(Collectors.toList());
    }

    public boolean deleteExperienceByID(Long id) {
        if (experienceRepository.existsById(id)) {
            experienceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateExperience(Long id, ExperienceDto updatedExperience) {
        Experience existingExperience = experienceRepository.findById(id).orElse(null);

        if (existingExperience != null) {
            existingExperience.updateFromDto(updatedExperience);
            experienceRepository.save(existingExperience);
            return true;
        } else {
            return false;
        }
    }
}
