package com.subsmanagement.subscription.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class AddonSubscription extends Subscription{
    public AddonSubscription(Long id, String status, boolean autoRenew, LocalDateTime createTime, LocalDateTime lastUpdateTime, Long serviceProviderId, String subscriberEmail) {
        super(id, status, autoRenew, false, createTime, lastUpdateTime, serviceProviderId, subscriberEmail);
    }
}