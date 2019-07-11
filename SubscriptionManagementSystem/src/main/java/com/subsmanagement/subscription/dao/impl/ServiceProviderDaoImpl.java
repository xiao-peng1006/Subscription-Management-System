package com.subsmanagement.subscription.dao.impl;

import com.subsmanagement.subscription.entity.ServiceProvider;
import com.subsmanagement.subscription.repository.ServiceProviderRepository;
import com.subsmanagement.subscription.dao.ServiceProviderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProviderDaoImpl implements ServiceProviderDao {

    private final ServiceProviderRepository serviceProviderRepository;

    @Autowired
    public ServiceProviderDaoImpl(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public Optional<ServiceProvider> findById(Integer id) {
        return this.serviceProviderRepository.findById(id);
    }

    @Override
    public Optional<ServiceProvider> create(ServiceProvider serviceProvider) {
        return Optional.ofNullable(this.serviceProviderRepository.save(serviceProvider));
    }
}
