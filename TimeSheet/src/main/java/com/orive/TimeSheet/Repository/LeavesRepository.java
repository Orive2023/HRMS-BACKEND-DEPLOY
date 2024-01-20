package com.orive.TimeSheet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orive.TimeSheet.Entity.LeavesEntity;


public interface LeavesRepository extends JpaRepository<LeavesEntity, Long>{
	
	//find by employeeId
		@Query("SELECT l FROM LeavesEntity l WHERE l.employeeId = :employeeId")
		List<LeavesEntity> findByEmployeeId(@Param("employeeId") Long employeeId);

}
