package com.application.examappjava.dto;

import com.application.examappjava.entity.Education;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EducationDto {

    private long id;
    private String universityName;
    private String campus;
    private String degree;
    private double cgpa;
    private String startDate;
    private String endDate;
    private CandidateDto candidateDto;

    public EducationDto(Education education){
        this.id=education.getId();
        this.universityName=education.getUniversityName();
        this.campus=education.getCampus();
        this.degree=education.getDegree();
        this.cgpa=education.getCgpa();
        this.startDate=education.getStartDate();
        this.endDate= education.getEndDate();
        this.candidateDto=new CandidateDto(education.getCandidate());
    }

 public EducationDto(){

 }

}
