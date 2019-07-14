package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.SubscriberDao;
import com.subsmanagement.entity.Subscriber;
import com.subsmanagement.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriberDaoImpl implements SubscriberDao {

    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberDaoImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public Optional<Subscriber> findByEmail(String emailAddress) {
        return this.subscriberRepository.findByEmail(emailAddress);
    }

    @Override
    public Optional<Subscriber> create(Subscriber subscriber) {
        return Optional.ofNullable(this.subscriberRepository.save(subscriber));
    }


}
