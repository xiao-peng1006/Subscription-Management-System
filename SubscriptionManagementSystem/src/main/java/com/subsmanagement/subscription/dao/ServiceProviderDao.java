package com.subsmanagement.subscription.dao;

import com.subsmanagement.subscription.entity.ServiceProvider;

import java.util.Optional;

public interface ServiceProviderDao {

    Optional<ServiceProvider> findById(Integer id);

    Optional<ServiceProvider> create(ServiceProvider serviceProvider);
}
