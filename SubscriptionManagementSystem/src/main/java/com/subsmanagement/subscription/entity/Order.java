package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Order {
    private @Id Long id;
    private Date date;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private Long subscriptionId;
    private String email;
    private Long subscriptionPlanId;
}
