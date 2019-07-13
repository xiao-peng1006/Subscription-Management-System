package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    private boolean autoRenew;
    private boolean base;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private Integer serviceProviderId;
    private String subscriberEmail;
}
