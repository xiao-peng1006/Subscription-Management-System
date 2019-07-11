package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Subscription {
    private @Id Long id;
    private String status;
    private boolean autoRenew;
    private boolean base;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private Long serviceProviderId;
    private String subscriberEmail;
}
