package com.subsmanagement.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Subscription {
    private @Id Long id;
    private String status;
    private boolean autoRenew;
    private boolean base;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;

    private Long serviceProviderId;
    private String subscriberEmail;

    public Subscription(Long id, String status, boolean autoRenew, boolean base, LocalDateTime createTime, LocalDateTime lastUpdateTime, Long serviceProviderId, String subscriberEmail) {
        this.id = id;
        this.status = status;
        this.autoRenew = autoRenew;
        this.base = base;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.serviceProviderId = serviceProviderId;
        this.subscriberEmail = subscriberEmail;
    }
}
