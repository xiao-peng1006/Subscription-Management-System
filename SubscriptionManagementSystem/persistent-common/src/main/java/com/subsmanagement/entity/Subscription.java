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
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String status;

    private boolean autoRenew;
    private boolean base;

    @NotNull
    private LocalDateTime createTime;
    @NotNull
    private LocalDateTime lastUpdateTime;
    @NotNull
    private Integer serviceProviderId;
    @NotNull
    private String subscriberEmail;
}
