package com.application.examappjava.Dto;

import com.application.examappjava.Entity.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {
    private long id;
    private String companyName;
    private String role;
    private Date startYear;
    private Date endYear;
    private long expectedSalary;

    public ExperienceDto(Experience experience){
        this.setId(experience.getId());
        this.setCompanyName(experience.getCompanyName());
        this.setRole(experience.getRole());
        this.setStartYear(experience.getStartYear());
        this.setEndYear(experience.getEndYear());
        this.setExpectedSalary(experience.getExpectedSalary());
    }

    public Experience dissamble(){
        Experience experience=new Experience();

        experience.setId(id);
        experience.setCompanyName(companyName);
        experience.setRole(role);
        experience.setStartYear(startYear);
        experience.setEndYear(endYear);
        experience.setExpectedSalary(expectedSalary);
        return experience;
    }

}
