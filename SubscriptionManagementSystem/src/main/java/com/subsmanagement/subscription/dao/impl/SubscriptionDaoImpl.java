package com.subsmanagement.subscription.dao.impl;

import com.subsmanagement.subscription.dao.SubscriptionDao;
import com.subsmanagement.subscription.entity.Subscription;
import com.subsmanagement.subscription.repository.SubscriptionRepository;
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
    public List<Subscription> findByServiceProviderId(Integer id) {
        return this.subscriptionRepository.findByServiceProviderId(id);
    }

    @Override
    public List<Subscription> findBySubscriberEmailAddress(String emailAddress) {
        return this.subscriptionRepository.findBySubscriberEmail(emailAddress);
    }
}
