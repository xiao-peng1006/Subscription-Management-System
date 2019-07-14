package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.ServiceProviderDao;
import com.subsmanagement.entity.ServiceProvider;
import com.subsmanagement.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public Optional<ServiceProvider> create(ServiceProvider serviceProvider) {
        return Optional.ofNullable(this.serviceProviderRepository.save(serviceProvider));
    }
}
