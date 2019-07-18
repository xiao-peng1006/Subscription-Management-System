package com.subsmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreatePlanRequest {

    private Integer duration;
    private BigDecimal cost;
    private Integer serviceProviderId;
}
