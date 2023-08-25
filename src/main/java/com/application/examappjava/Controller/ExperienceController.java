package com.application.examappjava.controller;

import com.application.examappjava.dto.ExperienceDto;
import com.application.examappjava.service.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    private final ExperienceService experienceService;


    public ExperienceController( ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public ResponseEntity<Void> addExperience(@RequestBody final ExperienceDto experience) {
        experienceService.addExperience(experience);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDto> getExperienceByID(@PathVariable final Long id) {
        ExperienceDto experienceDto = experienceService.getExperienceByID(id);
        if (experienceDto != null) {
            return ResponseEntity.ok(experienceDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ExperienceDto>> getExperienceList() {
        List<ExperienceDto> educations = experienceService.getExperienceList();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperienceByID(@PathVariable final Long id) {
        boolean deleted = experienceService.deleteExperienceByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExperience(@PathVariable final Long id, @RequestBody final ExperienceDto updatedExperience) {
        boolean isSuccess = experienceService.updateExperience(id, updatedExperience);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
