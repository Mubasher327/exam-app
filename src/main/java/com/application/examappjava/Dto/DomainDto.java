package com.application.examappjava.Dto;

import com.application.examappjava.Entity.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DomainDto {

    private long id;
    private String name;
    private String description;
    private String createdBy;
    private String modifiedBy;

    public DomainDto (Domain domain){
        this.setId(domain.getId());
        this.setName(domain.getName());
        this.setDescription(domain.getDescription());
        this.setCreatedBy(domain.getCreatedBy());
        this.setModifiedBy(domain.getModifiedBy());

    }

    public Domain dissamble(){
        Domain domain= new Domain();

        domain.setId(id);
        domain.setName(name);
        domain.setDescription(description);
        domain.setCreatedBy(createdBy);
        domain.setModifiedBy(modifiedBy);

        return domain;
    }


}
