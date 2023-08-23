package com.application.examappjava.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="experience_id")
    private long id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="role")
    private String role;
    @Column(name="start_year")
    private Date startYear;
    @Column(name="end_year")
    private Date endYear;
    @Column(name="expected_salary")
    private long expectedSalary;

}
