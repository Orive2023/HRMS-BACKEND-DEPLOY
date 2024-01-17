package com.orive.Payroll.Entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class PaySlipIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "ORPAYSP";
    private static long sequence = 0;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Implement your custom logic here to generate the ID sequence-wise
        // For simplicity, I'm just using an incrementing sequence in memory
        return PREFIX + String.format("%03d", ++sequence);
    }
}