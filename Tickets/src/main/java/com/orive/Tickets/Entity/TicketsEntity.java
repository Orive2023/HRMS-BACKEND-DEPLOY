package com.orive.Tickets.Entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.orive.Tickets.Config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "tickets")
public class TicketsEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket-sequence")
    @GenericGenerator(name = "ticket-sequence", strategy = "com.orive.Tickets.Entity.TicketsIdGenerator")
	private String ticketsId;
	
	@Column(name = "tickets_code")
	@Convert(converter = AesEncryptor.class)
	private String ticketsCode;
	
	@Column(name = "subject")
	@Convert(converter = AesEncryptor.class)
	private String subject;
	
	@Column(name = "employee_name")
	@Convert(converter = AesEncryptor.class)
	private String employeeName;
	
	@Column(name = "employee_id")
	@Convert(converter = AesEncryptor.class)
	private Long employeeId;
	
	@Column(name = "priority")
	@Convert(converter = AesEncryptor.class)
	private String priority;
	
	@Column(name = "created_by")
	@Convert(converter = AesEncryptor.class)
	private String createdBy;
	
	@Column(name = "date")
	@Convert(converter = AesEncryptor.class)
	private LocalDate date;
	
	@Column(name = "project_title")
	@Convert(converter = AesEncryptor.class)
	private String projectTitle;
	
	@Column(name = "description")
	@Convert(converter = AesEncryptor.class)
	private String description;
}
