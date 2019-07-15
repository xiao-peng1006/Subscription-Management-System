package com.subsmanagement.repository;

import com.subsmanagement.entity.SubscriptionBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionBeneficiaryRepository extends
        JpaRepository<SubscriptionBeneficiary, SubscriptionBeneficiary.SubscriptionEmailKey> {

    List<SubscriptionBeneficiary> findAllBySubscriptionEmailKey_SubscriptionId(Integer subscriptionId);
}
