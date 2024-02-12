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


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "experience_letter")
public class ExperienceLetterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long experienceLetterId;
	
	@Column(name = "form_release_date")
	private LocalDate formReleaseDate;
	
	@Column(name = "referrence_number")
	private Long referrenceNumber;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	@Column(name = "leaves_date")
	private LocalDate leavesDate;
	
	@Column(name = "serving_period")
	private String  servingPeriod;
}
