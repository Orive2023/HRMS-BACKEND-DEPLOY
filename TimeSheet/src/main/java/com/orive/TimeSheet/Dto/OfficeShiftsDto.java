package com.orive.TimeSheet.Dto;

import java.time.LocalDate;
import java.util.Date;

import com.orive.TimeSheet.Configuration.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
public class OfficeShiftsDto {

	private Long officeShiftsId;
	private LocalDate createdDate;
	private String day;
	private String officeClockInTime;
	private String officeClockOutTime;
}
