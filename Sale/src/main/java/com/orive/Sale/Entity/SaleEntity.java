package com.orive.Sale.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.orive.Sale.Config.AesEncryptor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "sale")
public class SaleEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-sequence")
    @GenericGenerator(name = "custom-sequence", strategy = "com.orive.Sale.Entity.CustomIdGenerator")
	private String saleId;
	
	@Column(name = "developer_cost")
	private Double developerCost;
	
	@Column(name = "research_and_devlopment")
	private Double researchAndDevlopment;
	
	@Column(name = "customer_support_and_technical_assitance")
	private Double customerSupportAndTechnicalAssitance;
	
	@Column(name = "server_maintance")
	private Double serverMaintance;
	
	@Column(name = "customer_segment")
	private Double customerSegment;
	
	@Column(name = "distribution_channel")
	private Double distributionChannel;
	
	@Column(name = "third_party_software_component")
	private Double thirdPartySoftwareComponent;
	
	@Column(name = "per_user_price")
	private Double perUserPrice;
	
	@Column(name = "total_number_of_user")
	private Double totalNumberOfUser;
	
	@Column(name = "total_user_cost")
	private Double totalUserCost;
	
	@Column(name = "direct_sales_through_website")
	private Double directSalesThroughWebsite;
	
	@Column(name = "sales_team")
	private Double salesTeam;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@Column(name = "gst_price")
	private Double gstPrice;
	
	@Column(name = "total_cost")
	private Double totalCost;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "bill_to")
	private String billTo;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "gstin")
	private String gstin;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "ship_to")
	private String shipTo;
	
	@Column(name = "place_of_supply")
	private String placeOfSupply;
	
	@Column(name = "invoice_no")
	private Long invoiceNo;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "local_time")
	private String localTime;
	
	@Column(name = "tax_type")
	private String taxType;
	
	@Column(name = "taxable_amount")
	private Double taxableAmount;
	
	@Column(name = "rate")
	private Double rate;
	
	@Column(name = "tax_amount")
	private Double taxAmount;
	
	@Column(name = "sub_total")
	private Double subTotal;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "received")
	private Double received;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "invoice_amount_in_words")
	private String invoiceAmountInWords;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
    @Column(name = "terms_and_conditions")
	private String termsAndConditions;
	
    @Column(name = "bank_name")
	private String bankName;
	
    @Column(name = "bank_account_no")
	private Long bankAccountNo;
	
    @Column(name = "bank_ifsc_code")
	private String bankIfscCode;	
        
    @OneToMany(targetEntity =  SaleListingEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "sale_table_fk",referencedColumnName = "saleId")
	private List<SaleListingEntity> saleListingEntities;
}
