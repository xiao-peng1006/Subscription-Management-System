package com.subsmanagement.subscription.dao;

import com.subsmanagement.subscription.entity.SubscriptionBeneficiary;

import java.util.Optional;

public interface SubscriptionBeneficiaryDao {

    Optional<SubscriptionBeneficiary> create(SubscriptionBeneficiary subscriptionBeneficiary);
    Optional<SubscriptionBeneficiary> findById(SubscriptionBeneficiary.SubscriptionEmailKey subscriptionEmailKey);
}
