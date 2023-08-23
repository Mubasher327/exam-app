package com.application.examappjava.Dto;

import com.application.examappjava.Entity.Education;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

    private long id;
    private String universityName;
    private String campus;
    private String degree;
    private double cgpa;
    private String startDate;
    private String endDate;

    public EducationDto(Education education){
        this.setId(education.getId());
        this.setUniversityName(education.getUniversityName());
        this.setCampus(education.getCampus());
        this.setDegree(education.getDegree());
        this.setCgpa(education.getCgpa());
        this.setStartDate(education.getStartDate());
        this.setEndDate(education.getEndDate());
    }

    public Education dissamble(){
        Education education=new Education();

        education.setId(id);
        education.setUniversityName(universityName);
        education.setCampus(campus);
        education.setDegree(degree);
        education.setCgpa(cgpa);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        return education;
    }

}
