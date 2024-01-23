package com.orive.Procurement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Procurement.Entity.CommitteeListEntity;

public interface CommitteeListRepository extends JpaRepository<CommitteeListEntity, String> {
	
	List<CommitteeListEntity> findByBidAnalysisId(Long bidAnalysisId);
}
