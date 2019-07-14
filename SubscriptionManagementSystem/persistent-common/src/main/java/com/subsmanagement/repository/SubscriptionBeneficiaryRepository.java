package com.subsmanagement.repository;

import com.subsmanagement.entity.SubscriptionBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionBeneficiaryRepository extends
        JpaRepository<SubscriptionBeneficiary, SubscriptionBeneficiary.SubscriptionEmailKey> {

}
