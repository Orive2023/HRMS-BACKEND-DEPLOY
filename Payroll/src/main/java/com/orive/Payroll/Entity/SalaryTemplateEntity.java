package com.orive.Payroll.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.orive.Payroll.Config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "salary_template")
public class SalaryTemplateEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salarytemplate-sequence")
    @GenericGenerator(name = "salarytemplate-sequence", strategy = "com.orive.Payroll.Entity.SalaryTemplateIdGenerator")
	private String salaryTemplateId;
		
	@Column(name = "basic_salery")
	@Convert(converter = AesEncryptor.class)
	private double basicSalery;
	
	@Column(name = "house_rent_allowance")
	@Convert(converter = AesEncryptor.class)
	private double houseRentAllowance;
	
	@Column(name = "medical_allowance")
	@Convert(converter = AesEncryptor.class)
	private double medicalAllowance;
	
	@Column(name = "pf_allowance")
	@Convert(converter = AesEncryptor.class)
	private double pfAllowance;
	
	@Column(name = "tax_deductiion")
	@Convert(converter = AesEncryptor.class)
	private double taxDeductiion;

	@Column(name = "travelling_allowance")
	@Convert(converter = AesEncryptor.class)
	private double travellingAllowance;
	
	@Column(name = "dearness_allowance")
	@Convert(converter = AesEncryptor.class)
	private double dearnessAllowance;

	@Column(name = "gross_salery")
	@Convert(converter = AesEncryptor.class)
	private double grossSalery;
	
	@Column(name = "total_deduction")
	@Convert(converter = AesEncryptor.class)
	private double totalDeduction;
	
	@Column(name = "net_salery")
	@Convert(converter = AesEncryptor.class)
	private double netSalery;
	
	@Column(name = "payroll_template")
	@Convert(converter = AesEncryptor.class)
	private String payrollTemplate;	
	
	@Column(name = "created_date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate createdDate;
}
