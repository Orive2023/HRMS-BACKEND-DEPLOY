package com.orive.Employee.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
@Builder
@Table(name = "intern_joining_letter")
public class InternJoiningLetterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long internJoiningLetterId;
	
	@Column(name = "reference_no")
	private String referenceNo;
	
	@Column(name = "form_release_date")
	private LocalDate formReleaseDate;
	
	@Column(name = "office_address")
	private String officeAddress;
	
	@Column(name = "candidate_name")
	private String candidateName;
	
	@Column(name = "college_name")
	private String collegeName;
	
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	@Column(name = "submission_date")
	private LocalDate submissionDate;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "employee_designation")
	private String employeeDesignation;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "intern_stipend")
	private double internStipend;
	
	@Column(name = "weekly_come_office_for_days")
	private Long weeklyComeOfficeForDays;
	
	@Column(name = "reporting_to")
	private String reportingTo;
	
	@Column(name = "sign_bond_with_company_for_months")
	private String signBondWithCompanyForMonths;
}
