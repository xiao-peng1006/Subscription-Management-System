package com.subsmanagement.dao.impl;

import com.subsmanagement.PersistentCommonTests;
import com.subsmanagement.constant.enums.Status;
import com.subsmanagement.dao.SubscriptionDao;
import com.subsmanagement.entity.Subscription;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SubscriptionDaoImplIntegrationTests extends PersistentCommonTests {

    @Autowired
    private SubscriptionDao subscriptionDao;

    private Subscription subscription;

    private List<Subscription> subscriptionList;

    @Before
    public void setUp() {
        subscription = Subscription.builder()
                .status(Status.ACTIVE.name())
                .autoRenew(false)
                .base(true)
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .serviceProviderId(1)
                .subscriberEmail("test@test.com")
                .build();
        this.subscriptionList = new ArrayList<>();
        this.subscriptionList.add(this.subscription);
    }

    @Test
    @Transactional
    public void findSubscriptionById_withAValidId_shouldReturnAValidSubscription() {
        // Arrange
        Optional<Subscription> newSubscription = this.subscriptionDao.create(this.subscription);

        // Act
        Optional<Subscription> subscription = this.subscriptionDao.findById(newSubscription.get().getId());

        // Assert
        assertTrue(subscription.isPresent());
    }

    @Test
    @Transactional
    public void createSubscription_withValidData_shouldReturnAValidSubscription() {
        // Arrange

        // Act
        Optional<Subscription> subscription = this.subscriptionDao.create(this.subscription);

        // Assert
        assertTrue(subscription.isPresent());
        assertEquals(this.subscription, subscription.get());
    }

    @Test
    @Transactional
    public void findSubscriptionsByServiceProviderId_withAValidServiceProviderId_shouldReturnAVliadListOfSubscriptions() {
        // Arrange
        List<Optional<Subscription>> newSubscriptionList = new ArrayList<>();
        newSubscriptionList.add(this.subscriptionDao.create(this.subscription));

        // Act
        List<Subscription> subscriptionList = this.subscriptionDao.findByServiceProviderId(1);

        // Assert
        assertEquals(this.subscriptionList, subscriptionList);
    }

    @Test
    @Transactional
    public void findSubscriptionsBySubscriberEmailAddress_withAValidSubscriberEmailAddress_shouldReturnAValidListOfSubscription() {
        // Arrange
        List<Optional<Subscription>> newSubscriptionList = new ArrayList<>();
        newSubscriptionList.add(this.subscriptionDao.create(this.subscription));

        // Act
        List<Subscription> subscriptionList = this.subscriptionDao.findBySubscriberEmailAddress("test@test.com");

        // Assert
        assertEquals(this.subscriptionList, subscriptionList);
    }
}
