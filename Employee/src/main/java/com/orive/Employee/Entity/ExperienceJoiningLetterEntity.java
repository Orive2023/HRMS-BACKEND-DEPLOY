package com.orive.Employee.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "experience_joining_letter")
public class ExperienceJoiningLetterEntity {
	
	@Column(name = "experience_joining_letter_id")
	private Long experienceJoiningLetterId;
	
	@Column(name = "referrence_no")
	private String referrenceNo;
	
	@Column(name = "form_release_date")
	private LocalDate formReleaseDate;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "employee_address")
	private String employeeAddress;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "employee_designation")
	private String employeeDesignation;
	
	@Column(name = "annual_ctc")
	private double annualCtc;
	
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	@Column(name = "salary_component_per_month")
	private double salaryComponentPerMonth;
	
	@Column(name = "salary_component_per_basic")
	private double salaryComponentPerBasic;
	
	@Column(name = "special_allowance")
	private double specialAllowance;
	
	@Column(name = "gross_salary")
	private double grossSalary;
	
	@Column(name = "probation_period")
	private Long probationPeriod;
	
	@Column(name = "aaddharcard_no")
	private String aaddharcardNo;
	
	@Column(name = "pancard_no")
	private String pancardNo;
	
	@Column(name = "marksheets")
	private byte[] marksheets;
	
	@Column(name = "reporting_manager")
	private String reportingManager;
	
	@Column(name = "casual_sick_leaves")
	private Long casualSickLeaves;
	
	@Column(name = "earned_leaves")
	private Long earnedLeaves;
	
	@Column(name = "notice_period")
	private Long noticePeriod;
	
	@Column(name = "department")
	private String department;
}
