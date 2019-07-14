package com.subsmanagement.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Period {
    private @Id Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;

    private Integer subscriptionId;
    private Integer subscriptionPlanId;
    private Integer orderId;
}
