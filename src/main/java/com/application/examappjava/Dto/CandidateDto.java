package com.application.examappjava.Dto;

import com.application.examappjava.Entity.Candidate;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
    private long id;
    private String firstName;
    private String lastName;
    private long phoneNo;
    private String cnic;
    private String permanentAddress;
    private String currentAddress;

    public CandidateDto(Candidate candidate){
        this.setId(candidate.getId());
        this.setFirstName(candidate.getFirstName());
        this.setLastName(candidate.getLastName());
        this.setPhoneNo(candidate.getPhoneNo());
        this.setCnic(candidate.getCnic());
        this.setPermanentAddress(candidate.getPermanentAddress());
        this.setCurrentAddress(candidate.getCurrentAddress());
    }
    public Candidate dissamble(){
        Candidate candidate=new Candidate();
        candidate.setId(id);
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setPhoneNo(phoneNo);
        candidate.setCnic(cnic);
        candidate.setPermanentAddress(permanentAddress);
        candidate.setCurrentAddress(currentAddress);
        return candidate;

    }

}
