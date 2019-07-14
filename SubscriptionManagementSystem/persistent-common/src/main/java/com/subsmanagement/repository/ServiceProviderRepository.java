package com.subsmanagement.repository;

import com.subsmanagement.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {
}
