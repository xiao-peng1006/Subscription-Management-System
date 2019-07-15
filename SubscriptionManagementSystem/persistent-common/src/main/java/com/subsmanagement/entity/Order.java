package com.subsmanagement.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private String status;

    @NotNull
    private LocalDateTime createTime;

    @NotNull
    private LocalDateTime lastUpdateTime;

    @NotNull
    private Integer subscriptionId;

    @NotNull
    private String email;

    @NotNull
    private Integer subscriptionPlanId;
}
