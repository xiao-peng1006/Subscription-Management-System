package com.subsmanagement.subscription.repository;

import com.subsmanagement.subscription.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {
}
