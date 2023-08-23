package com.application.examappjava.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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


    @OneToMany(cascade = CascadeType.ALL)
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Experience> experiences = new ArrayList<>();
}
