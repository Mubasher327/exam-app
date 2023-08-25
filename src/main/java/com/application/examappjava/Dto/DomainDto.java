package com.application.examappjava.dto;

import com.application.examappjava.entity.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data

public class DomainDto {
    private long id;
    private String name;
    private String description;
    private int createdBy;
    private int modifiedBy;
    public DomainDto(){

    }
    public DomainDto(Domain domain) {
        this.id=domain.getId();
        this.name = domain.getName();
        this.description = domain.getDescription();
        this.createdBy = domain.getCreatedBy();
        this.modifiedBy = domain.getModifiedBy();
    }
    // abc
}