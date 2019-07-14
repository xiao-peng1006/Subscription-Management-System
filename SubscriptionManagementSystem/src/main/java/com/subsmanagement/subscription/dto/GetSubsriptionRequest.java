package com.subsmanagement.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class GetSubsriptionRequest {
    @NotNull
    private Integer subscriptionId;

}
