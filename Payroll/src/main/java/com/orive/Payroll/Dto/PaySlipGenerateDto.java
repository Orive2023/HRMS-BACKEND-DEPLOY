package com.orive.Payroll.Dto;


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

public class PaySlipGenerateDto {
	
	
	private Long paySlipGenerateId;
    private String employeeName;
    private Long employeeId;
    private String designation;
    private double hourlyWages;
    private Long totalAttendance;
    private double basicSalary;
    private double providentFund;
    private double esi;
    private double transportAllowance;
    private double hra;
    private double foodAllowance;
    private double uniformAllowance;
    private double servantAllowance;
    private double educationAllowance;
    private double projectAllowance;
    private double medicalAllowance;
    private double entatainmentAllowance;
    private double specialAllowance;
    private double leaveTravelAllowance;
    private double totalAllowance;
    private double totalDeduction;
    private double grossSalary;
    private double netSalary;
    private double ctc;
    private double itTaxDeduction;
	private double monthlyItTaxDeduction;
	private double finalTotalDeductionWithTax;
	private double finalNetSalaryWithTax;

}

