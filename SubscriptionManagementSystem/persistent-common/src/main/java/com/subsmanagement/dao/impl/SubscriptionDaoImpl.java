package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.SubscriptionDao;
import com.subsmanagement.entity.Subscription;
import com.subsmanagement.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionDaoImpl implements SubscriptionDao {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionDaoImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> findById(Integer id) { return this.subscriptionRepository.findById(id); }

    @Override
    @Transactional
    public Optional<Subscription> create(Subscription subscription) {
        return Optional.ofNullable(this.subscriptionRepository.save(subscription));
    }

    @Override
    public List<Subscription> findAllByServiceProviderId(Integer id) {
        return this.subscriptionRepository.findAllByServiceProviderId(id);
    }

    @Override
    public List<Subscription> findAllBySubscriberEmailAddress(String emailAddress) {
        return this.subscriptionRepository.findAllBySubscriberEmail(emailAddress);
    }
}
