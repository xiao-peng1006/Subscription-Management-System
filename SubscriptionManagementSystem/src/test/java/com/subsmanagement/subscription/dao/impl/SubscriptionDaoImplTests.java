package com.subsmanagement.subscription.dao.impl;

import com.subsmanagement.subscription.constant.enums.Status;
import com.subsmanagement.subscription.dao.SubscriptionDao;
import com.subsmanagement.subscription.entity.Subscription;
import com.subsmanagement.subscription.repository.SubscriptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionDaoImplTests {

    @Mock
    private SubscriptionRepository mockSubscriptionRepository;
    private SubscriptionDao mockSubscriptionDao;
    private Subscription subscription;
    private List<Subscription> subscriptionList;

    @Before
    public void setUp() {
        this.mockSubscriptionDao = new SubscriptionDaoImpl(this.mockSubscriptionRepository);
        this.subscription = Subscription.builder()
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
    public void findById_happyPath() {
        // Arrange
        int mockId = 1;
        when(this.mockSubscriptionRepository.findById(mockId))
                .thenReturn(Optional.ofNullable(this.subscription));
        // Act
        Optional<Subscription> subscriptionReturned = this.mockSubscriptionDao.findById(mockId);

        // Assert
        assertTrue(subscriptionReturned.isPresent());
        assertEquals(this.subscription, subscriptionReturned.get());
    }

    @Test
    public void create_happyPath() {
        // Arrange
        when(this.mockSubscriptionRepository.save(this.subscription))
                .thenReturn(this.subscription);

        // Act
        Optional<Subscription> subscriptionReturned = this.mockSubscriptionDao.create(this.subscription);

        // Assert
        assertTrue(subscriptionReturned.isPresent());
        assertEquals(this.subscription, subscriptionReturned.get());
    }

    @Test
    public void findByServiceProviderId_happyPath() {
        // Arrange
        int mockServiceProviderId = 1;
        when(this.mockSubscriptionRepository.findByServiceProviderId(mockServiceProviderId))
                .thenReturn(this.subscriptionList);

        // Act
        List<Subscription> subscriptionListReturned = this.mockSubscriptionDao.findByServiceProviderId(mockServiceProviderId);

        // Assert
        assertEquals(this.subscriptionList, subscriptionListReturned);
    }

    @Test
    public void findBySubscriberEmailAddress_happyPath() {
        // Arrange
        String mockSubscriberEmailAddress = "test@test.com";
        when(this.mockSubscriptionRepository.findBySubscriberEmailAddress(mockSubscriberEmailAddress))
                .thenReturn(this.subscriptionList);

        // Act
        List<Subscription> subscriptionReturned = this.mockSubscriptionDao.findBySubscriberEmailAddress(mockSubscriberEmailAddress);

        // Assert
        assertEquals(this.subscriptionList, subscriptionReturned);
    }
}
