package com.subsmanagement.dao.impl;

import com.subsmanagement.PersistentCommonTests;
import com.subsmanagement.dao.SubscriptionBeneficiaryDao;
import com.subsmanagement.entity.SubscriptionBeneficiary;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class SubscriptionBeneficiaryDaoImplIntegrationTests extends PersistentCommonTests {

    @Autowired
    private SubscriptionBeneficiaryDao subscriptionBeneficiaryDao;

    private static final String EMAIL = "test@test.com";
    private static final int SUBSCRIPTION_ID = 1;
    private SubscriptionBeneficiary subscriptionBeneficiary;

    @Before
    public void setUp(){
        this.subscriptionBeneficiary = SubscriptionBeneficiary.builder()
                .subscriptionEmailKey(new SubscriptionBeneficiary.SubscriptionEmailKey(SUBSCRIPTION_ID, EMAIL))
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    @Transactional
    public void createSubscriptionBeneficiary_withValidData_shouldReturnAValidSubscriptionBeneficiary() {
        // Arrange


        // Act
        Optional<SubscriptionBeneficiary> subscriptionBeneficiaryOptional = this.subscriptionBeneficiaryDao.create(subscriptionBeneficiary);

        // Assert
        assertTrue(subscriptionBeneficiaryOptional.isPresent());
        assertEquals(subscriptionBeneficiary, subscriptionBeneficiaryOptional.get());
    }

    @Test
    @Transactional
    public void findSubscriptionBeneficiaryById_withvalidId_shouldReturnAValidSubscriptionBeneficiary() {
        // Arrange
        this.subscriptionBeneficiaryDao.create(this.subscriptionBeneficiary);

        // Act
        Optional<SubscriptionBeneficiary> subscriptionBeneficiaryOptional =
                this.subscriptionBeneficiaryDao.findById(this.subscriptionBeneficiary.getSubscriptionEmailKey());

        // Assert
        assertTrue(subscriptionBeneficiaryOptional.isPresent());
        assertEquals(subscriptionBeneficiary, subscriptionBeneficiaryOptional.get());
    }

    @Test
    @Transactional
    public void findAllSubscriptionBeneficiaryBySubscriptionId_withvalidId_shouldReturnAllValidSubscriptionBeneficiary() {
        // Arrange
        this.subscriptionBeneficiaryDao.create(this.subscriptionBeneficiary);
        this.subscriptionBeneficiary.setSubscriptionEmailKey(new SubscriptionBeneficiary.SubscriptionEmailKey(
                this .subscriptionBeneficiary.getSubscriptionEmailKey().getSubscriptionId(), "another@test.com"
        ));
        this.subscriptionBeneficiaryDao.create(this.subscriptionBeneficiary);

        // Act
        List<SubscriptionBeneficiary> subscriptionBeneficiaries = this.subscriptionBeneficiaryDao
                .findAllBySubscriptionId(this.subscriptionBeneficiary.getSubscriptionEmailKey().getSubscriptionId());

        // Assert
        assertFalse(subscriptionBeneficiaries.isEmpty());
        assertEquals(2, subscriptionBeneficiaries.size());
    }
}