package com.application.examappjava.entity;

import com.application.examappjava.dto.EducationDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

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

    @Column(name="deleted")
    private boolean deleted=false;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Candidate_Id")
    private Candidate candidate;


    public Education(EducationDto educationDto, Candidate candidate){
        this.universityName=educationDto.getUniversityName();
        this.campus=educationDto.getCampus();
        this.degree=educationDto.getDegree();
        this.cgpa= educationDto.getCgpa();
        this.startDate=educationDto.getStartDate();
        this.endDate= educationDto.getEndDate();
        this.candidate=candidate;
    }

//    public void updateFromDto(EducationDto educationDto){
//        this.universityName=educationDto.getUniversityName();
//        this.campus=educationDto.getCampus();
//        this.degree=educationDto.getDegree();
//        this.cgpa= educationDto.getCgpa();
//        this.startDate=educationDto.getStartDate();
//        this.endDate= educationDto.getEndDate();
//
//    }

}
