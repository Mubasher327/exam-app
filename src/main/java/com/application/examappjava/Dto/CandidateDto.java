package com.application.examappjava.dto;

import com.application.examappjava.entity.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class CandidateDto {
    private long id;
    private String firstName;
    private String lastName;
    private long phoneNo;
    private String cnic;
    private String permanentAddress;
    private String currentAddress;

    public CandidateDto(Candidate candidate){
        this.id=candidate.getId();
        this.firstName=candidate.getFirstName();
        this.lastName=candidate.getLastName();
        this.phoneNo=candidate.getPhoneNo();
        this.cnic= candidate.getCnic();
        this.permanentAddress=candidate.getPermanentAddress();
        this.currentAddress=candidate.getCurrentAddress();
    }
    public CandidateDto(){

    }


}
