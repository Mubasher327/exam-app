package com.application.examappjava.entity;

import com.application.examappjava.dto.EducationDto;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data

@Table(name="educationDetail")
public class Education {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="education_id")
    private long id;

    @Column(name="University_name")
    private String universityName;

    @Column(name="campus")
    private String campus;

    @Column(name="degree")
    private String degree;

    @Column(name="cgpa")
    private double cgpa;

    @Column(name="start_date")
    private String startDate;

    @Column(name="end_date")
    private String endDate;


    @ManyToOne
    @JoinColumn(name = "CandidateId")
    private Candidate candidate;

    public Education(){

    }

    public Education(EducationDto educationDto){
        this.universityName=educationDto.getUniversityName();
        this.campus=educationDto.getCampus();
        this.degree=educationDto.getDegree();
        this.cgpa= educationDto.getCgpa();
        this.startDate=educationDto.getStartDate();
        this.endDate= educationDto.getEndDate();
    }

    public void updateFromDto(EducationDto educationDto){
        this.universityName=educationDto.getUniversityName();
        this.campus=educationDto.getCampus();
        this.degree=educationDto.getDegree();
        this.cgpa= educationDto.getCgpa();
        this.startDate=educationDto.getStartDate();
        this.endDate= educationDto.getEndDate();

    }

}
