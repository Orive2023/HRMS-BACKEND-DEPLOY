package com.orive.Performance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orive.Performance.Entity.PerformanceAppraisalEntity;

public interface PerformanceAppraisalRepository extends JpaRepository<PerformanceAppraisalEntity, String> {
	
	//Query for find by employeeId
	 List<PerformanceAppraisalEntity> findPerformanceAppraisalByEmployeeId(String username);
	//  @Query("SELECT p FROM PerformanceAppraisalEntity p WHERE p.employeeId = :employeeId")
	//  List<PerformanceAppraisalEntity> findPerformanceAppraisalByEmployeeId(@Param("employeeId") Long employeeId);

}
