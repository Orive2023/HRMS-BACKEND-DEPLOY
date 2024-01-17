package com.orive.Procurement.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.orive.Procurement.Config.AesEncryptor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "request")
public class RequestEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestId;
	
	@Column(name = "requesting_person")
	@Convert(converter = AesEncryptor.class)
	private String requestingPerson;
	
	@Column(name = "requesting_department")
	@Convert(converter = AesEncryptor.class)
	private String requestingDepartment;	
	
	@Column(name = "expected_time_to_have_the_good_starts")
	@Convert(converter = AesEncryptor.class)
	private LocalDate expectedTimeToHaveTheGoodStarts;
	
	@Column(name = "expected_time_to_have_the_good_ends")
	@Convert(converter = AesEncryptor.class)
	private LocalDate expectedTimeToHaveTheGoodEnds;
	
	@Column(name = "reason_for_requesting")
	@Convert(converter = AesEncryptor.class)
	private String reasonForRequesting;
	
	@Column(name = "created_date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate createdDate;
	
	@OneToMany(targetEntity = DescriptionOfMaterialListEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "request_description_fk",referencedColumnName = "requestId")
	private List<DescriptionOfMaterialListEntity> descriptionOfMaterialEntities;
}
