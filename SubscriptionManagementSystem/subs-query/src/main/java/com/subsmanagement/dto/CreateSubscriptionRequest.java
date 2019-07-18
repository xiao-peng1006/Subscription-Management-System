package com.subsmanagement.dto;

import com.subsmanagement.constant.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreateSubscriptionRequest {

    private Status status;
    private Boolean autoRenew;
    private Boolean isBase;
    private Integer serviceProviderId;
    private String subscriberEmail;
}
