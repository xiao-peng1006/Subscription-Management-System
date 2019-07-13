package com.subsmanagement.subscription.dao;

import com.subsmanagement.subscription.entity.Subscriber;

import java.util.Optional;

public interface SubscriberDao {

    Optional<Subscriber> findByEmail(String emailAddress);

    Optional<Subscriber> create(Subscriber subscriber);
}
