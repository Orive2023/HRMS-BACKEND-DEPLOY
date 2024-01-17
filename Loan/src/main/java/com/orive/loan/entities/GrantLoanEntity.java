package com.orive.loan.entities;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.orive.loan.configuration.AesEncryptor;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "grantloan")
public class GrantLoanEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan-sequence")
    @GenericGenerator(name = "loan-sequence", strategy = "com.orive.loan.entities.LoanIdGenerator")
	private String grantLoanId;
	
	@Column(name = "employee_name")
	@Convert(converter = AesEncryptor.class)
	private String employeeName;
	
	@Column(name = "permitted_by")
	@Convert(converter = AesEncryptor.class)
	private String permittedBy;
	
	@Column(name = "loan_details")
	@Convert(converter = AesEncryptor.class)
	private String loanDetails;
	
	@Column(name = "approve_date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate approveDate;
	
	@Column(name = "repayment_form")
	@Convert(converter = AesEncryptor.class)
	private LocalDate repaymentForm;
	
	@Column(name = "amount")
	@Convert(converter = AesEncryptor.class)
	private double amount;
	
	@Column(name = "interest_persentage")
	@Convert(converter = AesEncryptor.class)
	private double interestPersentage;
	
	@Column(name = "installment_period")
	@Convert(converter = AesEncryptor.class)
	private double installmentPeriod;
	
	@Column(name = "repayment_total")
	@Convert(converter = AesEncryptor.class)
	private double repaymentTotal;
	
	@Column(name = "installment")
	@Convert(converter = AesEncryptor.class)
	private double installment;
	
//	@Column(name = "status")
//	private String status;
	
	@Column(name = "installment_cleared")
	@Convert(converter = AesEncryptor.class)
	private int installmentCleared;
	
	@Column(name = "total_payment_cleared")
	@Convert(converter = AesEncryptor.class)
	private double totalPaymentCleared;
}
