package com.subsmanagement.dao.impl;

import com.subsmanagement.PersistentCommonTests;
import com.subsmanagement.dao.ServiceProviderDao;
import com.subsmanagement.entity.ServiceProvider;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServiceProviderDaoImplIntegrationTests extends PersistentCommonTests {

    @Autowired
    private ServiceProviderDao serviceProviderDao;

    private ServiceProvider serviceProvider;

    @Before
    public void setUp() {
        serviceProvider = ServiceProvider.builder()
                .name("DATADOG")
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    @Transactional
    public void findServiceProviderById_withAValidId_shouldReturnAValidServiceProvider(){
        // Arrange
        Optional<ServiceProvider> newServiceProvider = this.serviceProviderDao.create(this.serviceProvider);

        // Act
        Optional<ServiceProvider> serviceProvider = this.serviceProviderDao.findById(newServiceProvider.get().getId());

        // Assert
        assertTrue(serviceProvider.isPresent());
    }

    @Test
    @Transactional
    public void createServiceProvider_withValidData_shouldReturnAValidServiceProvider(){
        // Arrange

        // Act
        Optional<ServiceProvider> serviceProvider = this.serviceProviderDao.create(this.serviceProvider);

        // Assert
        assertTrue(serviceProvider.isPresent());
        assertEquals(this.serviceProvider, serviceProvider.get());
    }
}
