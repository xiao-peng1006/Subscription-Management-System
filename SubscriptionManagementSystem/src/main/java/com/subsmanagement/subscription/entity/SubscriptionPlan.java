package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SubscriptionPlan {
    private @Id Integer id;
    private Integer duration;
    private BigDecimal cost;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private Integer subscriptionId;
}
