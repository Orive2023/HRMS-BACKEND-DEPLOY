package com.orive.TimeSheet.Entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "attendance")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;
	
	@Column(name = "office_clock_in")
	private String officeClockIn;
	
	@Column(name = "office_clock_out")
	private String officeClockOut;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "clock_in")
	private String clockIn;
	
	@Column(name = "clock_out")
	private String clockOut;
	
	@Column(name = "late")
	private String late;
	
	@Column(name = "early_leaving")
	private String earlyLeaving;
	
	@Column(name = "over_time")
	private String overTime;
	
	@Column(name = "total_work")
	private String totalWork;
	
	@Column(name ="total_rest" )
	private Long totalRest;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "clock_in_location")
	private String clockInLocation;
	
	@Column(name = "clock_out_location")
	private String clockOutLocation;
	
//	@Lob
//	@Column(name = "upload_doc",  length = 100000)
//	private byte[] uploadDoc;
	
	
	//prePersist method
	 @PrePersist
	    public void prePersist() {
	        // Perform any logic or calculations before the entity is persisted (inserted into the database)
	        calculateTotalWork(); // Call the method to calculate total work duration
	        setOverTime(calculateOvertime());
	        setLate(calculateLate());
	        setEarlyLeaving(calculateEarlyLeaving());
	    }

	 //preUpdate method
	    @PreUpdate
	    public void preUpdate() {
	        // Perform any logic or calculations before the entity is updated in the database
	        calculateTotalWork(); // Call the method to calculate total work duration
	        setOverTime(calculateOvertime());
	        setLate(calculateLate());
	        setEarlyLeaving(calculateEarlyLeaving());
	    }

	    //calculateTotalWork method
	    private void calculateTotalWork() {
	        if (clockIn != null && clockOut != null) {
	            // Calculate total work duration
	            LocalTime startTime = LocalTime.parse(clockIn);
	            LocalTime endTime = LocalTime.parse(clockOut);
	            Duration totalWorkDuration = Duration.between(startTime, endTime);

	            // Convert total work duration to hours and minutes
	            long totalMinutes = totalWorkDuration.toMinutes();
	            long hours = totalMinutes / 60;
	            long minutes = totalMinutes % 60;

	            // Update the totalWork field with the formatted result
	            setTotalWork(String.format("%dh %02dmin", hours, minutes));
	        }
	    }
	    
	    //calculateOvertime method
	    private String calculateOvertime() {
	        if (clockOut != null && officeClockOut != null) {
	            // Calculate overtime as the difference between clock-out and office clock-out time
	            LocalTime endTime = LocalTime.parse(clockOut);
	            LocalTime officeEndTime = LocalTime.parse(officeClockOut);
	            Duration overtimeDuration = Duration.between(endTime, officeEndTime);

	            // Convert overtime duration to hours and minutes
	            long overtimeMinutes = overtimeDuration.toMinutes();
	            long overtimeHours = overtimeMinutes / 60;
	            long overtimeMinutesRemainder = overtimeMinutes % 60;

	            // Return the formatted result
	            return String.format("%dh %02dmin", overtimeHours, overtimeMinutesRemainder);
	        }
	        return null; // Return null if clockOut or officeClockOut is not available
	    }
	    
	    //calculateLate method
	    private String calculateLate() {
	        if (clockIn != null && officeClockIn != null) {
	            // Calculate late as the difference between clock-in time and office clock-in time
	            LocalTime startTime = LocalTime.parse(clockIn);
	            LocalTime officeStartTime = LocalTime.parse(officeClockIn);
	            Duration lateDuration = Duration.between(officeStartTime, startTime);

	            // Convert late duration to hours and minutes
	            long lateMinutes = lateDuration.toMinutes();
	            long lateHours = lateMinutes / 60;
	            long lateMinutesRemainder = lateMinutes % 60;

	            // Return the formatted result
	            return String.format("%dh %02dmin", lateHours, lateMinutesRemainder);
	        }
	        return null; // Return null if clockIn or officeClockIn is not available
	    }
	    
	    //calculateEarlyLeaving method
	    private String calculateEarlyLeaving() {
	        if (clockOut != null && officeClockOut != null) {
	            // Parse the clock-out times
	            LocalTime endTime = LocalTime.parse(clockOut);
	            LocalTime officeEndTime = LocalTime.parse(officeClockOut);

	            // Check if the employee clocked out before the office clock-out time
	            if (endTime.isBefore(officeEndTime)) {
	                // Calculate early leaving as the difference between office clock-out time and clock-out time
	                Duration earlyLeavingDuration = Duration.between(endTime, officeEndTime);

	                // Convert early leaving duration to hours and minutes
	                long earlyLeavingMinutes = earlyLeavingDuration.toMinutes();
	                long earlyLeavingHours = earlyLeavingMinutes / 60;
	                long earlyLeavingMinutesRemainder = earlyLeavingMinutes % 60;

	                // Return the formatted result
	                return String.format("%dh %02dmin", earlyLeavingHours, earlyLeavingMinutesRemainder);
	            }
	        }
	        return null; // Return null if clockOut or officeClockOut is not available, or if there's no early leaving
	    }
}