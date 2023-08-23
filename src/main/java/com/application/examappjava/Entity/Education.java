package com.application.examappjava.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="educationDetail")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="education_id")
    private long id;
    @Column(name="University_name")
    private String universityName;
    @Column(name="campus")
    private String campus;
    @Column(name="degree")
    private String degree;
    @Column(name="cgpa")
    private double cgpa;
    @Column(name="start_date")
    private String startDate;
    @Column(name="end_date")
    private String endDate;


}
