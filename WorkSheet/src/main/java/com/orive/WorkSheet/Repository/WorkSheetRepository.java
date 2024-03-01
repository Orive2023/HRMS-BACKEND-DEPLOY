package com.orive.WorkSheet.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.orive.WorkSheet.Entity.WorkSheetEntity;

public interface WorkSheetRepository extends JpaRepository<WorkSheetEntity, String>{
	
	//Query for find by employeeId
	@Query("SELECT w FROM WorkSheetEntity w WHERE w.username = :username")
	List<WorkSheetEntity> findByUsername(@Param("username") String username);
	
	
	//Query for find duplicate using workSheetTitle And project
	@Query("SELECT w FROM WorkSheetEntity w WHERE w.workSheetTitle = :workSheetTitle AND w.project = :project")
	Optional<WorkSheetEntity> findByWorkSheetTitleAndProject(@Param("workSheetTitle") String workSheetTitle, @Param("project") String project);
}
