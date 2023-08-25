package com.application.examappjava.entity;

import com.application.examappjava.dto.CandidateDto;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Entity
@Data

@Table(name="candidateInfo")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="candidate_id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_no")
    private long phoneNo;

    @Column(name="cnic")
    private String cnic;

    @Column(name="Permanent_address")
    private String permanentAddress;

    @Column(name="current_address")
    private String currentAddress;

    @OneToMany(mappedBy = "candidate")
    private List<Education> educations;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    public Candidate(){

    }
    public Candidate(CandidateDto candidateDto){
        this.firstName= candidateDto.getFirstName();
        this.lastName= candidateDto.getLastName();
        this.phoneNo= candidateDto.getPhoneNo();
        this.cnic=candidateDto.getCnic();
        this.permanentAddress= candidateDto.getPermanentAddress();
        this.currentAddress= candidateDto.getCurrentAddress();
    }

    public void updateFromDto(CandidateDto candidateDto){
        this.lastName= candidateDto.getLastName();
        this.firstName= candidateDto.getFirstName();
        this.phoneNo= candidateDto.getPhoneNo();
        this.cnic=candidateDto.getCnic();
        this.permanentAddress= candidateDto.getPermanentAddress();
        this.currentAddress= candidateDto.getCurrentAddress();
    }

}
