package com.orive.Performance.Entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SelfAssessmentIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "ORSA";
    private static long sequence = 1;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Implement your custom logic here to generate the ID sequence-wise
        // For simplicity, I'm just using an incrementing sequence in memory
        return PREFIX + String.format("%03d", sequence++);
    }
}