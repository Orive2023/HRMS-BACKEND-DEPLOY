package com.orive.WorkSheet.Dto;

import java.time.LocalDate;
import java.util.Date;

import com.orive.WorkSheet.Enum.Status;

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
public class WorkSheetDto {

    private String workSheetId;
	private String workSheetTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private double estimateHour;
	private String projectName;
	private String employeeName;
	private String username;
	private String assignedTo;
	private String description;
	private String taskName;
	private String challangePart;
	private String workProgress;
	private LocalDate createdDate;
	private String status;
}
