package com.subsmanagement.dao;

import com.subsmanagement.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionDao {

    Optional<Subscription> findById(Integer id);

    Optional<Subscription> create(Subscription subscription);

    List<Subscription> findAllByServiceProviderId(Integer id);

    List<Subscription> findAllBySubscriberEmailAddress(String emailAddress);
}
