package com.subsmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class GetSubscriptionRequest {
    @NotNull
    private Integer subscriptionId;

}
