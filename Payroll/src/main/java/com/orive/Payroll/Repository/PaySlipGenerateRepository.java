package com.orive.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Payroll.Entity.PaySlipGenerateEntity;

public interface PaySlipGenerateRepository extends JpaRepository<PaySlipGenerateEntity, String> {

}
