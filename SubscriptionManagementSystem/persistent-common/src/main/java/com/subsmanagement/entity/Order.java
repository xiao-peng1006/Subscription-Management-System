package com.subsmanagement.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "`order`")
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
