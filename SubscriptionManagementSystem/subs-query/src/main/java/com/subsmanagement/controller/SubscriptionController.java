package com.subsmanagement.controller;

import com.subsmanagement.dao.SubscriptionDao;
import com.subsmanagement.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionDao subscriptionDao;

    @Autowired
    public SubscriptionController(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    @GetMapping("/{id}")
    public Subscription getSubscription(Integer id) {
        if (id < 1) {
            throw new IllegalArgumentException("Invalid subscription id: " + id);
        }

        Optional<Subscription> subscription = this.subscriptionDao.findById(id);

        if (!subscription.isPresent()) {
            throw new NotFoundException("Subscription: " + id + " has no beneficiary");
        }

        return subscription.get();
    }

}
