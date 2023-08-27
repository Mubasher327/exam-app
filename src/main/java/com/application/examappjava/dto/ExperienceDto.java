package com.application.examappjava.dto;

import com.application.examappjava.entity.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExperienceDto {
    private long id;
    private String companyName;
    private String role;
    private String startYear;
    private String endYear;
    private long expectedSalary;
    private long currentSalary;

    public ExperienceDto(Experience experience){
        this.setId(experience.getId());
        this.setCompanyName(experience.getCompanyName());
        this.setRole(experience.getRole());
        this.setStartYear(experience.getStartYear());
        this.setEndYear(experience.getEndYear());
        this.setExpectedSalary(experience.getExpectedSalary());
        this.setCurrentSalary(experience.getCurrentSalary());
    }
    public Experience toEntity(){
        Experience experience=new Experience();
        experience.setId(id);
        experience.setCompanyName(companyName);
        experience.setRole(role);
        experience.setStartYear(startYear);
        experience.setEndYear(endYear);
        experience.setExpectedSalary(expectedSalary);
        experience.setCurrentSalary(currentSalary);
        return experience;
    }

}
