package com.subsmanagement.dao;

import com.subsmanagement.entity.Subscriber;

import java.util.Optional;

public interface SubscriberDao {

    Optional<Subscriber> findByEmail(String emailAddress);

    Optional<Subscriber> create(Subscriber subscriber);
}
