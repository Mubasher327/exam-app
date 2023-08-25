package com.application.examappjava.dto;

import com.application.examappjava.entity.Experience;
import lombok.Data;

@Data

public class ExperienceDto {
    private long id;
    private String companyName;
    private String role;
    private String startYear;
    private String endYear;
    private long expectedSalary;
    private long currentSalary;

    public ExperienceDto(Experience experience){
        this.id=experience.getId();
        this.companyName=experience.getCompanyName();
        this.role=experience.getRole();
        this.startYear=experience.getStartYear();
        this.endYear=experience.getEndYear();
        this.expectedSalary=experience.getExpectedSalary();
        this.currentSalary=experience.getCurrentSalary();
    }
public ExperienceDto(){
}

}
