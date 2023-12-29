package com.orivesolutions.hrms.interviewscheduler.domain;

import lombok.Data;


import java.time.LocalDate;

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
    private String name;
    private String requirements;
    private String projectName;
    private String managerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobLocation;

}
