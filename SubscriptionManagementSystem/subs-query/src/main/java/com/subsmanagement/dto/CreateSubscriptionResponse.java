package com.subsmanagement.dto;

import com.subsmanagement.constant.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreateSubscriptionResponse {

    private Integer id;
    private Status status;
    private Boolean autoRenew;
    private Boolean isBase;
    private Integer serviceProviderId;
    private String subscriberEmail;
    private LocalDateTime createTime;
}
