package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.SubscriptionBeneficiaryDao;
import com.subsmanagement.entity.SubscriptionBeneficiary;
import com.subsmanagement.repository.SubscriptionBeneficiaryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionBeneficiaryDaoImplTests {

    @Mock
    private SubscriptionBeneficiaryRepository subscriptionBeneficiaryRepository;
    private SubscriptionBeneficiaryDao subscriptionBeneficiaryDao;
    private SubscriptionBeneficiary subscriptionBeneficiary;

    @Before
    public void setUp(){
        this.subscriptionBeneficiaryDao = new SubscriptionBeneficiaryDaoImpl(this.subscriptionBeneficiaryRepository);
        this.subscriptionBeneficiary = SubscriptionBeneficiary.builder()
                .subscriptionEmailKey(new SubscriptionBeneficiary.SubscriptionEmailKey(1, "test@gmail.com"))
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    public void findSubscriptionBeneficiaryById_happyPath(){
        // Arrange
        when(this.subscriptionBeneficiaryRepository.findById(this.subscriptionBeneficiary.getSubscriptionEmailKey()))
                .thenReturn(Optional.of(this.subscriptionBeneficiary));

        // Act
        Optional<SubscriptionBeneficiary> subscriptionBeneficiaryOptional =
                this.subscriptionBeneficiaryDao.findById(this.subscriptionBeneficiary.getSubscriptionEmailKey());

        // Assert
        assertTrue(subscriptionBeneficiaryOptional.isPresent());
        assertEquals(this.subscriptionBeneficiary, subscriptionBeneficiaryOptional.get());
    }

    @Test
    public void findAllSubscriptionBeneficiaryBySubscriptionId_happyPath(){
        // Arrange
        when(this.subscriptionBeneficiaryRepository.findAllBySubscriptionEmailKey_SubscriptionId(
                this.subscriptionBeneficiary.getSubscriptionEmailKey().getSubscriptionId()))
                .thenReturn(Arrays.asList(new SubscriptionBeneficiary(), new SubscriptionBeneficiary()));

        // Act
        List<SubscriptionBeneficiary> subscriptionBeneficiaries = this.subscriptionBeneficiaryDao
                .findAllBySubscriptionId(this.subscriptionBeneficiary.getSubscriptionEmailKey().getSubscriptionId());

        // Assert
        assertFalse(subscriptionBeneficiaries.isEmpty());
        assertEquals(2, subscriptionBeneficiaries.size());
    }

    @Test
    public void createSubscriptionBeneficiary_happyPath(){
        // Arrange
        when(this.subscriptionBeneficiaryRepository.save(this.subscriptionBeneficiary))
                .thenReturn(this.subscriptionBeneficiary);

        // Act
        Optional<SubscriptionBeneficiary> subscriptionBeneficiaryOptional =
                this.subscriptionBeneficiaryDao.create(this.subscriptionBeneficiary);

        // Assert
        assertTrue(subscriptionBeneficiaryOptional.isPresent());
        assertEquals(this.subscriptionBeneficiary, subscriptionBeneficiaryOptional.get());
    }
}
