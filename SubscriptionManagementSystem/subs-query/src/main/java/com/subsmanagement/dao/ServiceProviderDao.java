package com.subsmanagement.dao;

import com.subsmanagement.entity.ServiceProvider;

import java.util.Optional;

public interface ServiceProviderDao {

    Optional<ServiceProvider> findById(Integer id);

    Optional<ServiceProvider> create(ServiceProvider serviceProvider);
}
