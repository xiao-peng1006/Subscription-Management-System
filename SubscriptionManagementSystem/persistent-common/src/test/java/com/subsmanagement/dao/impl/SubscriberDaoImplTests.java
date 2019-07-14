package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.SubscriberDao;
import com.subsmanagement.entity.Subscriber;
import com.subsmanagement.repository.SubscriberRepository;
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
public class SubscriberDaoImplTests {

    @Mock
    private SubscriberRepository mockSubscriberRepository;
    private SubscriberDao mockSubscriberDao;
    private Subscriber subscriber;

    @Before
    public void setUp() {
        this.mockSubscriberDao = new SubscriberDaoImpl(this.mockSubscriberRepository);
        this.subscriber = Subscriber.builder()
                .email("test@test.com")
                .firstName("first")
                .lastName("last")
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    public void findByEmail_happyPath() {
        // Arrange
        String mockEmailAddress = "test@test.com";
        when(this.mockSubscriberRepository.findByEmail(mockEmailAddress))
                .thenReturn(Optional.ofNullable(this.subscriber));

        // Act
        Optional<Subscriber> subscriberReturned = this.mockSubscriberDao.findByEmail(mockEmailAddress);

        // Assert
        assertTrue(subscriberReturned.isPresent());
        assertEquals(this.subscriber, subscriberReturned.get());
    }

    @Test
    public void create_happyPath() {
        // Arrange
        when(this.mockSubscriberRepository.save(this.subscriber))
                .thenReturn(this.subscriber);

        // Act
        Optional<Subscriber> subscriberReturned = this.mockSubscriberDao.create(this.subscriber);

        // Assert
        assertTrue(subscriberReturned.isPresent());
        assertEquals(this.subscriber, subscriberReturned.get());
    }

}
