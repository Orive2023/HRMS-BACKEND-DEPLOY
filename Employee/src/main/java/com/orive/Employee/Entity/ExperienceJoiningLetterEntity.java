package com.orive.Employee.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long experienceJoiningLetterId;
	
//	@Column(name = "referrence_no")
	@Column(name = "referrence_no", length = 5)
	private String referrenceNo;
	
	@Column(name = "form_release_date")
	private LocalDate formReleaseDate;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "username")
	private String username;
	
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
	private String marksheets;
//	private byte[] marksheets;
	
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
	
//	@PrePersist
//    @PreUpdate
//    private void generateReferenceNumber() {
//        if (referrenceNo == null) {
//            // Generate the specific number based on your requirements
//            String datePart = LocalDate.now().toString().replace("-", "");
//            String randomPart = String.format("%05d", (int) (Math.random() * 10000)); // 5-digit random number
//            referrenceNo = "REF-" + datePart + "-" + randomPart;
//        }
//      }
	 
//	@PrePersist
//	@PreUpdate
//	private void generateReferenceNumber() {
//	    if (referrenceNo == null) {
//	        // Generate the specific number based on your requirements
//	        
//	        // Generate a random part (e.g., 8 characters)
//	        String randomPart = generateRandomString(8);
//	        
//	        // Combine randomPart with a prefix to form the reference number
//	        referrenceNo = "REF-" + randomPart;
//
//	        // Truncate the reference number if it exceeds the allowed length
//	        if (referrenceNo.length() > 15) {
//	            referrenceNo = referrenceNo.substring(0, 15);
//	        }
//	    }
//	}
//
//	private String generateRandomString(int length) {
//	    StringBuilder randomStringBuilder = new StringBuilder();
//	    for (int i = 0; i < length; i++) {
//	        char randomChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
//	        randomStringBuilder.append(randomChar);
//	    }
//	    return randomStringBuilder.toString().toUpperCase(); // Convert to uppercase if needed
//	}
	
	}

