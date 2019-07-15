package com.subsmanagement.dao;

import com.subsmanagement.entity.SubscriptionBeneficiary;

import java.util.List;
import java.util.Optional;

public interface SubscriptionBeneficiaryDao {

    Optional<SubscriptionBeneficiary> create(SubscriptionBeneficiary subscriptionBeneficiary);
    Optional<SubscriptionBeneficiary> findById(SubscriptionBeneficiary.SubscriptionEmailKey subscriptionEmailKey);
    List<SubscriptionBeneficiary> findAllBySubscriptionId(Integer subcriptionId);
}
