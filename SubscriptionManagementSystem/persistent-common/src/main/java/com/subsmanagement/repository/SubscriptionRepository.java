package com.subsmanagement.repository;

import com.subsmanagement.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findByServiceProviderId(Integer id);

    List<Subscription> findBySubscriberEmail(String emailAddress);
}