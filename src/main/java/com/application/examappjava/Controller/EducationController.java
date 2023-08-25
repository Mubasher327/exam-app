package com.application.examappjava.controller;

import com.application.examappjava.dto.EducationDto;
import com.application.examappjava.service.EducationService;
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
@RequestMapping("/education")
public class EducationController {
    private final EducationService educationService;


    public EducationController( EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<Void> addEducation(@RequestBody final EducationDto education) {
        educationService.addEducation(education);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDto> getEducationByID(@PathVariable final Long id) {
        EducationDto educationDto = educationService.getEducationByID(id);
        if (educationDto != null) {
            return ResponseEntity.ok(educationDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<EducationDto>> getEducationList() {
        List<EducationDto> educations = educationService.getEducationList();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEducationByID(@PathVariable final Long id) {
        boolean deleted = educationService.deleteEducationByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEducation(@PathVariable final Long id, @RequestBody final EducationDto updatedEducation) {
        boolean isSuccess = educationService.updateEducation(id, updatedEducation);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
