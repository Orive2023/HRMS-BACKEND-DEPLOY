package com.orive.project.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.orive.project.Configruration.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "employeeProjectManagement")
public class EmployeeProjectManagementEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeprojectmanagement-sequence")
    @GenericGenerator(name = "employeeprojectmanagement-sequence", strategy = "com.orive.project.Entity.EmployeeProjectmanagementIdGenerator")
	private String employeeProjectManagementId;
	
	@Column(name = "employee_id")
	@Convert(converter = AesEncryptor.class)
	private Long employeeId;
	
	@Column(name = "project_name")
	@Convert(converter = AesEncryptor.class)
	private String projectName;
	
	@Column(name = "employee_name")
	@Convert(converter = AesEncryptor.class)
	private String employeeName;
	
	@Column(name = "task_assigned_for")
	@Convert(converter = AesEncryptor.class)
	private String taskAssignedFor;
	
	@Column(name = "type_the_task_here")
	@Convert(converter = AesEncryptor.class)
	private String typeTheTaskHere;
}
