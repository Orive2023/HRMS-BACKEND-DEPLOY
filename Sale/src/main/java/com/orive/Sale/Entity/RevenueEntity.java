package com.orive.Sale.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
@ToString
@Builder
@Entity
@Table(name = "revenue")
public class RevenueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long revenueId;
	
	@Column(name = "product_price_per_unit")
	private Double productPricePerUnit;
	
	@Column(name = "no_of_clients")
	private Double noOfClients;
	
	@Column(name = "gross_revenue")
	private Double grossRevenue;
	
	@Column(name = "sale_date")
	private LocalDate saleDate;
	
	@Column(name = "returns")
	private Double returns;
	
	@Column(name = "discounts")
	private Double discounts;
	
	@Column(name = "allowances")
	private Double allowances;
	
	@Column(name = "net_revenue")
	private Double netRevenue;
	
	@Column(name = "money_added_bank_name")
	private String moneyAddedBankName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "product_name")
	private String productName;
	
	
	 @PrePersist
	    private void beforePersist() {
	        calculateGrossRevenue();
	        calculateNetRevenue();
	    }

	    @PreUpdate
	    private void beforeUpdate() {
	        calculateGrossRevenue();
	        calculateNetRevenue();
	    }

	    private void calculateGrossRevenue() {
	        if (productPricePerUnit != null && noOfClients != null) {
	            this.grossRevenue = productPricePerUnit * noOfClients;
	       
	        }
	    }
	    
	    private void calculateNetRevenue() {
	        if (this.grossRevenue != null && returns != null && discounts != null && allowances != null) {
	            netRevenue = this.grossRevenue - (returns + discounts + allowances);
	        }
	    }
}
