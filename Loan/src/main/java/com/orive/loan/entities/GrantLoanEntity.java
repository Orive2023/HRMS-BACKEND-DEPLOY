package com.orive.loan.entities;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import com.orive.loan.Enum.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "grantloan")
public class GrantLoanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grantLoanId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "permitted_by")
	private String permittedBy;
	
	@Column(name = "loan_details")
	private String loanDetails;
	
	@Column(name = "approve_date")
	private LocalDate approveDate;
	
	@Column(name = "repayment_form")
	private LocalDate repaymentForm;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "interest_persentage")
	private double interestPersentage;
	
	@Column(name = "installment_period")
	private double installmentPeriod;
	
	@Column(name = "repayment_total")
	private double repaymentTotal;
	
	@Column(name = "installment")
	private double installment;
	
	@Column(name = "installment_cleared")
	private int installmentCleared;
	
	@Column(name = "total_payment_cleared")
	private double totalPaymentCleared;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
}
