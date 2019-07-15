package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.SubscriptionBeneficiaryDao;
import com.subsmanagement.entity.SubscriptionBeneficiary;
import com.subsmanagement.repository.SubscriptionBeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionBeneficiaryDaoImpl implements SubscriptionBeneficiaryDao {

    private final SubscriptionBeneficiaryRepository subscriptionBeneficiaryRepository;

    @Autowired
    public SubscriptionBeneficiaryDaoImpl(SubscriptionBeneficiaryRepository subscriptionBeneficiaryRepository) {
        this.subscriptionBeneficiaryRepository = subscriptionBeneficiaryRepository;
    }

    @Override
    @Transactional
    public Optional<SubscriptionBeneficiary> create(SubscriptionBeneficiary subscriptionBeneficiary) {
        Optional<SubscriptionBeneficiary> subscriptionBeneficiaryOptional = findById(subscriptionBeneficiary.getSubscriptionEmailKey());
        if(subscriptionBeneficiaryOptional.isPresent()){
            return Optional.empty();
        }

        return Optional.ofNullable(this.subscriptionBeneficiaryRepository.save(subscriptionBeneficiary));
    }

    @Override
    public Optional<SubscriptionBeneficiary> findById(SubscriptionBeneficiary.SubscriptionEmailKey subscriptionEmailKey) {
        return this.subscriptionBeneficiaryRepository.findById(subscriptionEmailKey);
    }

    @Override
    public List<SubscriptionBeneficiary> findAllBySubscriptionId(Integer subcriptionId) {
        return this.subscriptionBeneficiaryRepository.findAllBySubscriptionEmailKey_SubscriptionId(subcriptionId);
    }
}
