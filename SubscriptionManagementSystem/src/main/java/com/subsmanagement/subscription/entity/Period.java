package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Period {
    private @Id Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;

    private Long subscriptionId;
    private Long subscriptionPlanId;
    private Long orderId;
}
