package com.subsmanagement;

import com.subsmanagement.dao.SubscriberDao;
import com.subsmanagement.entity.Subscriber;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.subsmanagement.SubscriptionManagementTests;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubscriberDaoImplIntegrationTests extends SubscriptionManagementTests {

    @Autowired
    private SubscriberDao subscriberDao;

    private Subscriber subscriber;

    @Before
    public void setUp() {
        this.subscriber = Subscriber.builder()
                .email("test@test.com")
                .firstName("first")
                .lastName("last")
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    @Transactional
    public void findByEmail_withAValidEmailAddress_shouldReturnAValidSubscriber() {
        // Arrange
        String mockEmailAddress = "test@test.com";
        Optional<Subscriber> subscriber = this.subscriberDao.create(this.subscriber);

        // Act
        Optional<Subscriber> subscriberReturned = this.subscriberDao.findByEmail(mockEmailAddress);

        // Assert
        assertTrue(subscriberReturned.isPresent());
        assertEquals(this.subscriber, subscriberReturned.get());
    }

    @Test
    @Transactional
    public void createSubscriber_withValidData_shouldReturnAValidSubscriber() {
        // Arrange
        Optional<Subscriber> subscriber = this.subscriberDao.create(this.subscriber);

        // Act
        Optional<Subscriber> subscriberReturned = this.subscriberDao.create(this.subscriber);

        // Assert
        assertTrue(subscriberReturned.isPresent());
        assertEquals(this.subscriber, subscriberReturned.get());
    }
}
