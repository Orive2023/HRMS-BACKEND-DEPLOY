package com.orive.Sale.Dto;

import java.time.LocalDate;
import java.util.List;

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
public class RevenueDto {

    private Long revenueId;
	private Double productPricePerUnit;
	private Double noOfClients;
	private Double grossRevenue;
	private LocalDate saleDate;
	private Double returns;
	private Double discounts;
	private Double allowances;
	private Double netRevenue;
	private String moneyAddedBankName;
	private String status;
	private String productName;
	private String billTo;
	private String address;
	private String gstin;
	private String state;
	private String shipTo;
	private String placeOfSupply;
	private Long invoiceNo;
	private LocalDate date;
	private String localTime;
	private String taxType;
	private Double taxableAmount;
	private Double rate;
	private Double taxAmount;
	private Double subTotal;
	private Double total;
	private Double received;
	private Double balance;
	private String invoiceAmountInWords;
	private String paymentMode;
	private String termsAndConditions;
	private String bankName;
	private Long bankAccountNo;
	private String bankIfscCode;	
	private List<RevenueListingDto> revenueListingEntities;
}
