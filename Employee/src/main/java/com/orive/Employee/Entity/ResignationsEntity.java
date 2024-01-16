package com.orive.Employee.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import com.orive.Employee.Configuration.AesEncryptor;

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
@Table(name = "resignations")
public class ResignationsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resignationId;
	
	@Column(name = "employee_name")
	@Convert(converter = AesEncryptor.class)
	private String employeeName;
	
	@Column(name = "notice_date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate noticeDate;
	
	@Column(name = "resignation_date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate resignationDate;
	
	@Column(name = "resignation_reason")
	@Convert(converter = AesEncryptor.class)
	private String resignationReason;
}
