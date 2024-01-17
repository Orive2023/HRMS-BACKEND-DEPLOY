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
@Table(name = "warnings")
public class WarningsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warningsId;
	
	@Column(name = "warning_to_employee")
	@Convert(converter = AesEncryptor.class)
	private String warningToEmployee;
	
	@Column(name = "warning_type")
	@Convert(converter = AesEncryptor.class)
	private String warningType;
	
	@Column(name = "subject")
	@Convert(converter = AesEncryptor.class)
	private String subject;
	
	@Column(name = "warning_by_employee")
	@Convert(converter = AesEncryptor.class)
	private String warningByEmployee;
	
	@Column(name = "warning_date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate warningDate;
	
	@Column(name = "description")
	@Convert(converter = AesEncryptor.class)
	private String description;
}
