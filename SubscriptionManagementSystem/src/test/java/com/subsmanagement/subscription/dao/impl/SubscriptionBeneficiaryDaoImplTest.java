package com.subsmanagement.subscription.dao.impl;

import com.subsmanagement.subscription.SubscriptionApplicationTests;
import com.subsmanagement.subscription.dao.SubscriptionBeneficiaryDao;
import com.subsmanagement.subscription.entity.SubscriptionBeneficiary;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubscriptionBeneficiaryDaoImplTest extends SubscriptionApplicationTests {

    @Autowired
    private SubscriptionBeneficiaryDao subscriptionBeneficiaryDao;

    private static final String EMAIL = "someemail@gmail.com";
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
}