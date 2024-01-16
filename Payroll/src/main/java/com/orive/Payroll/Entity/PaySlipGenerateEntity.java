package com.orive.Payroll.Entity;


import com.orive.Payroll.Config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "pay_slip_generate")

public class PaySlipGenerateEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paySlipGenerateId;
    
	@Column(name = "employee_name")
	@Convert(converter = AesEncryptor.class)
    private String employeeName; 

	@Column(name = "employee_id")
	@Convert(converter = AesEncryptor.class)
    private Long employeeId; 

	@Column(name = "designation")
	@Convert(converter = AesEncryptor.class)
    private String designation;

	@Column(name = "hourly_wages")
	@Convert(converter = AesEncryptor.class)
    private double hourlyWages;  

	@Column(name = "total_attendance")
	@Convert(converter = AesEncryptor.class)
    private Long totalAttendance;  

	@Column(name = "basic_salary")
	@Convert(converter = AesEncryptor.class)
    private double basicSalary;    

	@Column(name = "provident_fund")
	@Convert(converter = AesEncryptor.class)
    private double providentFund; 

	@Column(name = "esi")
	@Convert(converter = AesEncryptor.class)
    private double esi;

	@Column(name = "transport_allowance")
	@Convert(converter = AesEncryptor.class)
    private double transportAllowance;  

	@Column(name = "hra")
	@Convert(converter = AesEncryptor.class)
    private double hra;  

	@Column(name = "food_allowance")
	@Convert(converter = AesEncryptor.class)
    private double foodAllowance;

	@Column(name = "uniform_allowance")
	@Convert(converter = AesEncryptor.class)
    private double uniformAllowance; 

	@Column(name = "servant_allowance")
	@Convert(converter = AesEncryptor.class)
    private double servantAllowance;   

	@Column(name = "education_allowance")
	@Convert(converter = AesEncryptor.class)
    private double educationAllowance;   

	@Column(name = "project_allwance")
	@Convert(converter = AesEncryptor.class)
    private double projectAllowance;
    
	@Column(name = "medical_allowance")
	@Convert(converter = AesEncryptor.class)
    private double medicalAllowance;  

	@Column(name = "entatainment_allowance")
	@Convert(converter = AesEncryptor.class)
    private double entatainmentAllowance;   

	@Column(name = "special_allowance")
	@Convert(converter = AesEncryptor.class)
    private double specialAllowance;    

	@Column(name = "leave_travel_allowance")
	@Convert(converter = AesEncryptor.class)
    private double leaveTravelAllowance;  

	@Column(name = "total_allowance")
	@Convert(converter = AesEncryptor.class)
    private double totalAllowance;    

	@Column(name = "total_deduction")
	@Convert(converter = AesEncryptor.class)
    private double totalDeduction;   

	@Column(name = "gross_salary")
	@Convert(converter = AesEncryptor.class)
    private double grossSalary;  

	@Column(name = "net_salary")
	@Convert(converter = AesEncryptor.class)
    private double netSalary;  

	@Column(name = "ctc")
	@Convert(converter = AesEncryptor.class)
    private double ctc;   

	@Column(name = "it_tax_deduction")
	@Convert(converter = AesEncryptor.class)
    private double itTaxDeduction;	

	@Column(name = "monthly_it_tax_deduction")
	@Convert(converter = AesEncryptor.class)
	private double monthlyItTaxDeduction;	

	@Column(name = "final_total_deduction_with_tax")
	@Convert(converter = AesEncryptor.class)
	private double finalTotalDeductionWithTax;

	@Column(name = "final_net_salary_with_tax")
	@Convert(converter = AesEncryptor.class)
	private double finalNetSalaryWithTax;
	
	
	
	
 // This method will be called before the entity is persisted

    @PrePersist
    public void calculateBasicSalaryOnPersist() {
    	
        this.basicSalary = hourlyWages * totalAttendance;
        this.providentFund = 0.12 * basicSalary;
        this.esi = 0.0075 * basicSalary;
        calculateTotalAllowance();
        calculateGrossSalary();
        calculateTotalDeduction(); 
        
        // Added this line      
        calculateNetSalary();
        calculateCtc();
        calculateIncomeTaxDeduction();
        calculateMonthlyItTaxDeduction();
        calculateFinalTotalDeductionWithTax();
        calculateFinalNetSalaryWithTax();
    }


    
 // This method will be called before the entity is updated

    @PreUpdate
    public void calculateBasicSalaryOnUpdate() {

        this.basicSalary = hourlyWages * totalAttendance;
        this.providentFund = 0.12 * basicSalary;
        this.esi = 0.0075 * basicSalary;
        calculateTotalAllowance();
        calculateGrossSalary();
        calculateTotalDeduction(); 
        
        // Added this line        
        calculateNetSalary();
        calculateCtc();
        calculateIncomeTaxDeduction();
        calculateMonthlyItTaxDeduction();
        calculateFinalTotalDeductionWithTax();
        calculateFinalNetSalaryWithTax();
    }


    
 // Calculate total allowance based on individual allowances

    private void calculateTotalAllowance() {

        this.totalAllowance = transportAllowance + hra + foodAllowance + uniformAllowance
                + servantAllowance + educationAllowance + projectAllowance
                + medicalAllowance + entatainmentAllowance + specialAllowance
                + leaveTravelAllowance;
    }



// Calculate total deduction based on providentFund and esi

    private void calculateTotalDeduction() {
    	
        this.totalDeduction = providentFund + esi;
    }

    

// Calculate gross salary as the sum of basicSalary and totalAllowance

    private void calculateGrossSalary() {

        this.grossSalary = basicSalary + totalAllowance;
    }

    

 // Calculate net salary as the difference between grossSalary and totalDeduction

    private void calculateNetSalary() {

        this.netSalary = grossSalary - totalDeduction;
    }

    

// Calculate CTC as 12 times the netSalary

    private void calculateCtc() {

        this.ctc = netSalary * 12;
    }

    

// Calculate income tax deduction based on CTC range

    private void calculateIncomeTaxDeduction() {
        double ctcRangeStart1 = 300000;
        double ctcRangeEnd1 = 600000;
        double deductionPercentage1 = 0.05; 
        
        // 5%
        double ctcRangeStart2 = 600000;
        double ctcRangeEnd2 = 900000;
        double deductionPercentage2 = 0.10; 
        
        // 10%     
        double ctcRangeStart3 = 900000;
        double ctcRangeEnd3 = 1200000;
        double deductionPercentage3 = 0.15; 
        
        // 15%               
        double ctcRangeStart4 = 1200000;
        double ctcRangeEnd4 = 1500000;
        double deductionPercentage4 = 0.20; 
        
        // 20%
        if (ctc > ctcRangeStart1 && ctc <= ctcRangeEnd1) {
            double taxableAmount = ctc - ctcRangeStart1;
            this.itTaxDeduction = taxableAmount * deductionPercentage1;
        } else if (ctc > ctcRangeStart2 && ctc <= ctcRangeEnd2) {
            double taxableAmount = ctc - ctcRangeStart2;
            this.itTaxDeduction = taxableAmount * deductionPercentage2;
        } else if (ctc > ctcRangeStart3 && ctc <= ctcRangeEnd3) {
            double taxableAmount = ctc - ctcRangeStart3;
            this.itTaxDeduction = taxableAmount * deductionPercentage3;
        }else if (ctc > ctcRangeStart4 && ctc <= ctcRangeEnd4) {
            double taxableAmount = ctc - ctcRangeStart4;
            this.itTaxDeduction = taxableAmount * deductionPercentage4;
        }else {
            this.itTaxDeduction = 0; 
            
            // No deduction if not in the specified ranges           
        }
    }

    

 // Calculate monthly income tax deduction based on annual deduction

    private void calculateMonthlyItTaxDeduction() {
        this.monthlyItTaxDeduction = itTaxDeduction / 12;
    }

    

 // Calculate final total deduction with tax

    private void calculateFinalTotalDeductionWithTax() {
        this.finalTotalDeductionWithTax = providentFund + esi + monthlyItTaxDeduction;
    }

    

 // Calculate final net salary with tax

    private void calculateFinalNetSalaryWithTax() {
        this.finalNetSalaryWithTax = grossSalary - finalTotalDeductionWithTax;
    }
}

	

