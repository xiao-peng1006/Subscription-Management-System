package com.subsmanagement.subscription.dao;

import com.subsmanagement.subscription.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionDao {

    Optional<Subscription> findById(Integer id);

    Optional<Subscription> create(Subscription subscription);

    List<Subscription> findByServiceProviderId(Integer id);

    List<Subscription> findBySubscriberEmailAddress(String emailAddress);
}
