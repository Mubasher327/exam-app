package com.application.examappjava.entity;

import com.application.examappjava.dto.ExperienceDto;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne
    @JoinColumn(name="CandidateId")
    private Candidate candidate;


    public Experience(ExperienceDto experienceDto){
        this.companyName=experienceDto.getCompanyName();
        this.role=experienceDto.getRole();
        this.startYear=experienceDto.getStartYear();
        this.endYear=experienceDto.getEndYear();
        this.expectedSalary=experienceDto.getExpectedSalary();
        this.currentSalary=experienceDto.getCurrentSalary();
    }

    public void updateFromDto(ExperienceDto experienceDto){
        this.companyName=experienceDto.getCompanyName();
        this.role=experienceDto.getRole();
        this.startYear=experienceDto.getStartYear();
        this.endYear=experienceDto.getEndYear();
        this.expectedSalary=experienceDto.getExpectedSalary();
        this.currentSalary=experienceDto.getCurrentSalary();

    }

}
