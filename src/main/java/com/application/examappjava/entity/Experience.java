package com.application.examappjava.entity;

import com.application.examappjava.dto.ExperienceDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="experience")

public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="experience_id")
    private long id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="role")
    private String role;

    @Column(name="start_year")
    private String startYear;

    @Column(name="end_year")
    private String endYear;

    @Column(name="expected_salary")
    private long expectedSalary;

    @Column(name="current_salary")
    private long currentSalary;

    @Column(name="deleted")
    private boolean deleted=false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


    public Experience(ExperienceDto experienceDto, Candidate candidate){
        this.companyName=experienceDto.getCompanyName();
        this.role=experienceDto.getRole();
        this.startYear=experienceDto.getStartYear();
        this.endYear=experienceDto.getEndYear();
        this.expectedSalary=experienceDto.getExpectedSalary();
        this.currentSalary=experienceDto.getCurrentSalary();
        this.candidate=candidate;
    }

//    public void updateFromDto(ExperienceDto experienceDto){
//        this.companyName=experienceDto.getCompanyName();
//        this.role=experienceDto.getRole();
//        this.startYear=experienceDto.getStartYear();
//        this.endYear=experienceDto.getEndYear();
//        this.expectedSalary=experienceDto.getExpectedSalary();
//        this.currentSalary=experienceDto.getCurrentSalary();
//
//    }

}
