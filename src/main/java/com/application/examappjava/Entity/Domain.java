package com.application.examappjava.entity;


import com.application.examappjava.dto.DomainDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Domain")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="createdBy")
    private int createdBy;

    @Column(name="modifiedBy")
    private int modifiedBy;

    @CreationTimestamp  // Automatically set by database during creation
    @Column(name = "createdAt", updatable = false)  // Not updatable
    private LocalDateTime createdAt;

    @UpdateTimestamp  // Automatically set by database during update
    @Column(name = "modifiedAt")  // Not explicitly updatable
    private LocalDateTime updatedAt;
    public Domain(){

    }

    public Domain(DomainDto domainDto) {
        this.name = domainDto.getName();
        this.description = domainDto.getDescription();
        this.createdBy = domainDto.getCreatedBy();
        this.modifiedBy = domainDto.getModifiedBy();
    }

    public void updateFromDto(DomainDto domainDto) {
        this.name = domainDto.getName();
        this.description = domainDto.getDescription();
        this.modifiedBy = domainDto.getModifiedBy();
    }

}