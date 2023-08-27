package com.application.examappjava.dto;

import com.application.examappjava.entity.Candidate;
import com.application.examappjava.entity.Education;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor

public class CandidateDto {
    private long id;
    private String firstName;
    private String lastName;
    private long phoneNo;
    private String cnic;
    private String permanentAddress;
    private String currentAddress;
    private List<ExperienceDto> experiences;
    private List<EducationDto> educations;


    public CandidateDto(Candidate candidate) {
        this.setId(candidate.getId());
        this.setFirstName(candidate.getFirstName());
        this.setLastName(candidate.getLastName());
        this.setPhoneNo(candidate.getPhoneNo());
        this.setCnic(candidate.getCnic());
        this.setPermanentAddress(candidate.getPermanentAddress());
        this.setCurrentAddress(candidate.getCurrentAddress());
        this.setEducations(candidate.getEducations().stream()
                .map(EducationDto::new)
                .collect(Collectors.toList()));
        this.setExperiences(candidate.getExperiences().stream()
                .map(ExperienceDto::new)
                .collect(Collectors.toList()));

    }
}
