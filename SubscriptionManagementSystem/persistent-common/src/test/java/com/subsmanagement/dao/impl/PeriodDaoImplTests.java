package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.PeriodDao;
import com.subsmanagement.entity.Period;
import com.subsmanagement.repository.PeriodRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PeriodDaoImplTests {

    @Mock
    private PeriodRepository mockPeriodRepository;
    private PeriodDao mockPeriodDao;
    private Period period;

    @Before
    public void setUp() {
        this.mockPeriodDao = new PeriodDaoImpl(this.mockPeriodRepository);
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
    public void findById_happyPath() {
        // Arrange
        int mockId = 1;
        when(this.mockPeriodRepository.findById(mockId))
                .thenReturn(Optional.ofNullable(this.period));

        // Act
        Optional<Period> periodReturned = this.mockPeriodDao.findById(mockId);

        // Assert
        assertTrue(periodReturned.isPresent());
        assertEquals(this.period, periodReturned.get());
    }

    @Test
    public void create_happyPath() {
        // Arrange
        when(this.mockPeriodRepository.save(this.period))
                .thenReturn(this.period);

        // Act
        Optional<Period> periodReturned = this.mockPeriodDao.create(this.period);

        // Assert
        assertTrue(periodReturned.isPresent());
        assertEquals(this.period, periodReturned.get());
    }
}
