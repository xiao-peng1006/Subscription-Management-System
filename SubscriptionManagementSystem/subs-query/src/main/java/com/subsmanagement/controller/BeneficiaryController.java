package com.subsmanagement.controller;

import com.subsmanagement.annotation.AdviceOK;
import com.subsmanagement.dao.SubscriptionBeneficiaryDao;
import com.subsmanagement.entity.SubscriptionBeneficiary;
import com.subsmanagement.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    private final SubscriptionBeneficiaryDao subscriptionBeneficiaryDao;

    @Autowired
    public BeneficiaryController(SubscriptionBeneficiaryDao subscriptionBeneficiaryDao) {
        this.subscriptionBeneficiaryDao = subscriptionBeneficiaryDao;
    }

    @GetMapping("/{subscriptionId}")
    @AdviceOK
    public List<SubscriptionBeneficiary> getBeneficiariesBySubscription(@PathVariable int subscriptionId){
        if(subscriptionId < 1){
            throw new IllegalArgumentException("Invalid subscription id: " + subscriptionId);
        }

        List<SubscriptionBeneficiary> subscriptionBeneficiaries =
                this.subscriptionBeneficiaryDao.findAllBySubscriptionId(subscriptionId);

        if(subscriptionBeneficiaries.isEmpty()){
            throw new NotFoundException("Subscription: " + subscriptionId + " has no beneficiary");
        }

        return subscriptionBeneficiaries;
    }
}
