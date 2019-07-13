package com.subsmanagement.subscription.repository;

import com.subsmanagement.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findByServiceProviderId(Integer id);

    List<Subscription> findBySubscriberEmail(String emailAddress);
}
