package com.orivesolutions.hrms.interviewscheduler.domain;

import lombok.Data;


import java.time.LocalDate;

import com.orivesolutions.hrms.interviewscheduler.config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "talent")
@Data
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    @Convert(converter = AesEncryptor.class)
    private String name;
    
    @Column(name = "requirements")
    @Convert(converter = AesEncryptor.class)
    private String requirements;
    
    @Column(name = "project_name")
    @Convert(converter = AesEncryptor.class)
    private String projectName;
    
    @Column(name = "manager_name")
    @Convert(converter = AesEncryptor.class)
    private String managerName;
    
    @Column(name = "start_date")
    @Convert(converter = AesEncryptor.class)
    private LocalDate startDate;
    
    @Column(name = "end_date")
    @Convert(converter = AesEncryptor.class)
    private LocalDate endDate;
    
    @Column(name = "job_location")
    @Convert(converter = AesEncryptor.class)
    private String jobLocation;

}
