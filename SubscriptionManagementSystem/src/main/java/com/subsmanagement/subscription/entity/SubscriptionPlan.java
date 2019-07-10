package com.subsmanagement.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SubscriptionPlan {
    private @Id Long id;
    private int duration;
    private int cost;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private Long subscriptionId;
}
