package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.ServiceProviderDao;
import com.subsmanagement.entity.ServiceProvider;
import com.subsmanagement.repository.ServiceProviderRepository;
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
public class ServiceProviderDaoImplTests {

    @Mock
    private ServiceProviderRepository mockServiceProviderRepository;
    private ServiceProviderDao mockServiceProviderDao;
    private ServiceProvider serviceProvider;

    @Before
    public void setUp(){
        this.mockServiceProviderDao = new ServiceProviderDaoImpl(this.mockServiceProviderRepository);
        this.serviceProvider = ServiceProvider.builder()
                .name("DATADOG")
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    public void findById_happyPath(){
        // Arrange
        int mockId = 1;
        when(this.mockServiceProviderRepository.findById(mockId))
                .thenReturn(Optional.ofNullable(this.serviceProvider));

        // Act
        Optional<ServiceProvider> serviceProviderReturned = this.mockServiceProviderDao.findById(mockId);

        // Assert
        assertTrue(serviceProviderReturned.isPresent());
        assertEquals(this.serviceProvider, serviceProviderReturned.get());
    }

    @Test
    public void createServiceProvider_happyPath(){
        // Arrange
        when(this.mockServiceProviderRepository.save(this.serviceProvider))
                .thenReturn(this.serviceProvider);

        // Act
        Optional<ServiceProvider> serviceProviderReturned = this.mockServiceProviderDao.create(this.serviceProvider);

        // Assert
        assertTrue(serviceProviderReturned.isPresent());
        assertEquals(this.serviceProvider, serviceProviderReturned.get());
    }
}
