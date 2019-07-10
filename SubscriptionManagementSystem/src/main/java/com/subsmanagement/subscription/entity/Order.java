package com.subsmanagement.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
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
