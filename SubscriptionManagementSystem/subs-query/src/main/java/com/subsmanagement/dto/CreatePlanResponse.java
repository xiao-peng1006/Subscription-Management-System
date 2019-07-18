package com.subsmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreatePlanResponse {

    private Integer id;
    private Integer duration;
    private BigDecimal cost;
    private Integer serviceProviderId;
    private LocalDateTime createTime;
}
