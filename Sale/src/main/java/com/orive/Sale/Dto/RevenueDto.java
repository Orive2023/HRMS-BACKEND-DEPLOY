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
	
}
