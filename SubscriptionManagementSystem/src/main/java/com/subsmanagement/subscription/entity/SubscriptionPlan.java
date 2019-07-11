package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SubscriptionPlan {
    private @Id Long id;
    private int duration;
    private int cost;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private Long subscriptionId;
}
