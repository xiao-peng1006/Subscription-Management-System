package com.subsmanagement.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscription_beneficiaries")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class SubscriptionBeneficiary {

    @Data
    @Embeddable
    @NoArgsConstructor @AllArgsConstructor
    public static class SubscriptionEmailKey implements Serializable {

        @NotNull
        private Integer subscriptionId;

        @NotNull
        @Max(45)
        private String email;

    }

    @Id @Embedded
    @NotNull
    private SubscriptionEmailKey subscriptionEmailKey;

    @NotNull
    private LocalDateTime createTime;

    @NotNull
    private LocalDateTime lastUpdateTime;
}
