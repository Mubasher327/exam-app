package com.application.examappjava.entity;

import com.application.examappjava.dto.CandidateDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

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

    @Column(name="deleted")
    private boolean deleted=false;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Experience> experiences =new ArrayList<>();

    public Candidate(CandidateDto candidateDto){
        this.firstName= candidateDto.getFirstName();
        this.lastName= candidateDto.getLastName();
        this.phoneNo= candidateDto.getPhoneNo();
        this.cnic=candidateDto.getCnic();
        this.permanentAddress= candidateDto.getPermanentAddress();
        this.currentAddress= candidateDto.getCurrentAddress();
    }

    public void addEducation(Education education) {
        education.setCandidate(this);
        educations.add(education);
    }

    public void addExperience(Experience experience) {
        experience.setCandidate(this);
        experiences.add(experience);
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
