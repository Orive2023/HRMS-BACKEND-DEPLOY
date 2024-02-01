package com.orive.TimeSheet.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.orive.TimeSheet.Entity.AttendanceEntity;


public interface AttendanceRepository extends JpaRepository<AttendanceEntity, String> {

	//Get method by using employeeId
	@Query("SELECT a FROM AttendanceEntity a WHERE a.employeeId = :employeeId")
	List<AttendanceEntity> findByEmployeeId(@Param("employeeId") Long employeeId);

	//Count the employees present today
		@Query("SELECT COUNT(a) FROM AttendanceEntity a WHERE a.date = CURRENT_DATE()")
		long countPresentEmployeesToday();
			
	    //find the employee By employeeName And Date
		@Query("SELECT a FROM AttendanceEntity a WHERE a.employeeName = :employeeName AND a.date = :date")
		Optional<AttendanceEntity> findByEmployeeNameAndDate(@Param("employeeName") String employeeName, @Param("date") LocalDate date);
		
		//find the employee By employeeId And Date
		@Query("SELECT a FROM AttendanceEntity a WHERE a.employeeId = :employeeId AND a.date = :date")
		Optional<AttendanceEntity> findByEmployeeIdAndDate(@Param("employeeId") Long employeeId, @Param("date") LocalDate date);
		
		//count the total overtime for particular month and date fetch by employeeId
		List<AttendanceEntity> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startOfMonth, LocalDate endOfMonth);

		//count total login times in a month
		 @Query("SELECT DISTINCT a.date FROM AttendanceEntity a WHERE MONTH(a.date) = :month AND YEAR(a.date) = :year AND a.employeeId = :employeeId")
		 List<LocalDate> getDistinctLoginDatesForMonth(@Param("month") int month, @Param("year") int year, @Param("employeeId") Long employeeId);
}
 