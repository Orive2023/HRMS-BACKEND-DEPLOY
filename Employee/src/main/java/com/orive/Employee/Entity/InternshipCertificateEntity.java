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
@Builder
@Entity
@Table(name = "internship_certificate")
public class InternshipCertificateEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long internshipCertificateId;
	
	@Column(name = "referrence_no")
	private String referrenceNo;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "registration_no")
	private String registrationNo;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "interns_name")
	private String internsName;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "director_name")
	private String directorName;
}
