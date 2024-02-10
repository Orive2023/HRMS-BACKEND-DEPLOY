package com.orive.Payroll.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "pay_slip_generator")
public class PaySlipGeneratorEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paySlipGeneratorId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "designation")
    private String designation;
	
	@Column(name = "no_of_working_days")
	private Double noOfWorkingDays;
	
	@Column(name = "employee_basic_salary")
    private Double employeeBasicSalary;
	
	@Column(name = "basic_salary")
    private Double basicSalary;
	
	@Column(name = "houserent_allowance")
    private Double houserentAllowance;
	
	@Column(name = "conveyance_allowance")
    private Double conveyanceAllowance;
	
	@Column(name = "medical_allowance")
	private Double medicalAllowance;
	
	@Column(name = "no_of_children")
    private Double noOfChildren;
	
	@Column(name = "company_prefered_allowance")
    private Double companyPreferedAllowance;
	
	@Column(name = "educational_allowance")
	private Double educationalAllowance;
	
	@Column(name = "travelling_allowance")
	private Double travellingAllowance;
	
	@Column(name = "dearness_allowance")
	private Double dearnessAllowance;
	
	@Column(name = "special_allowance")
	private Double specialAllowance;
	
	@Column(name = "other_allowance")
    private Double otherAllowance;
	
	@Column(name = "over_time")
	private Double overTime;
	
	@Column(name = "over_time_salary")
    private Double overTimeSalary;
	
	@Column(name = "gross_salary")
    private Double grossSalary;
	
	@Column(name = "provident_fund")
    private Double providentFund;
	
	@Column(name = "esic")
    private Double esic;
	
	@Column(name = "state")
    private Double State;
	
	@Column(name = "professional_tax")
    private Double professionalTax;
	
	@Column(name = "tds")
    private Double tds;
	
	@Column(name = "net_salary")
    private Double netSalary;
	
	@Column(name = "provident_fund_contri")
    private Double providentFundContri;
	
	@Column(name = "esic_contri")
    private Double esicContri;
	
	@Column(name = "gratuity")
    private Double gratuity;
	
	@Column(name = "gratuity_year")
    private Long gratuityYear;
	
	@Column(name = "bonus")
    private Double bonus;
	
	@Column(name = "variable_pay")
    private Double variablePay;
	
	@Column(name = "cost_to_company")
    private Double costToCompany;

}
