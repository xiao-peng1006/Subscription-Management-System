package com.subsmanagement.dao.impl;

import com.subsmanagement.PersistentCommonTests;
import com.subsmanagement.dao.PeriodDao;
import com.subsmanagement.entity.Period;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PeriodDaoImplIntegrationTests extends PersistentCommonTests {

    @Autowired
    private PeriodDao periodDao;

    private Period period;

    @Before
    public void setUp() {
        this.period = Period.builder()
                .id(1)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .subscriptionId(1)
                .subscriptionPlanId(1)
                .orderId(1)
                .build();
    }

    @Test
    @Transactional
    public void findPeriodById_withAValidId_shouldReturnAValidPeriod() {
        // Arrage
        Optional<Period> period = this.periodDao.create(this.period);

        // Act
        Optional<Period> periodReturned = this.periodDao.findById(this.period.getId());

        // Assert
        assertTrue(periodReturned.isPresent());
        assertEquals(this.period, periodReturned.get());
    }

    @Test
    @Transactional
    public void createPeriod_withValidData_shouldReturnAValidPeriod() {
        // Arrange
        Optional<Period> period = this.periodDao.create(this.period);

        // Act
        Optional<Period> periodReturned = this.periodDao.create(this.period);

        // Assert
        assertTrue(periodReturned.isPresent());
        assertEquals(this.period, periodReturned.get());
    }
}
