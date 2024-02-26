package com.orive.Sale.Dto;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Column;
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
public class SaleDto {

	
	private String saleId;
	private Double developerCost;
	private Double researchAndDevlopment;
	private Double customerSupportAndTechnicalAssitance;
	private Double serverMaintance;
	private Double customerSegment;
	private Double distributionChannel;
	private Double thirdPartySoftwareComponent;
	private Double perUserPrice;
	private Double totalNumberOfUser;
	private Double totalUserCost;
	private Double directSalesThroughWebsite;
	private Double salesTeam;
	private Double totalPrice;
	private Double gstPrice;
	private Double totalCost;
	private String status;
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
	private List<SaleListingDto> saleListingEntities;
}
