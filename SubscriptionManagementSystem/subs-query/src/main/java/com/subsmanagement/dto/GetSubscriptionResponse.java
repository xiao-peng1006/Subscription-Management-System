package com.subsmanagement.dto;

import com.subsmanagement.entity.AddonSubscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSubscriptionResponse {

    @NotNull
    private Integer subscriptionId;

    @NotNull
    private String Status;
    private Boolean autoRenew;

    @NotNull
    private String serviceProviderId;

    @NotNull
    @Max(45)
    private String subscriberEmail;

    @NotNull
    private LocalDateTime createTime;
    @NotNull
    private LocalDateTime lastUpdateTime;

    private List<AddonSubscription> addonSubscriptions;
}
