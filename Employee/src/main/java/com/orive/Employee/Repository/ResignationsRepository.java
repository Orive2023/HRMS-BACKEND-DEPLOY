package com.orive.Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orive.Employee.Entity.ResignationsEntity;


public interface ResignationsRepository extends JpaRepository<ResignationsEntity, Long> {

	@Query("SELECT d FROM ResignationsEntity d WHERE d.employeeName = :employeeName")
	Optional<ResignationsEntity> findByEmployeeName(String employeeName);
}
