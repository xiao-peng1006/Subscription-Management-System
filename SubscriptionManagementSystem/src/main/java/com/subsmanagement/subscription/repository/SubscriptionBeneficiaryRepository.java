package com.subsmanagement.subscription.repository;

import com.subsmanagement.subscription.entity.SubscriptionBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionBeneficiaryRepository extends
        JpaRepository<SubscriptionBeneficiary, SubscriptionBeneficiary.SubscriptionEmailKey> {

}
