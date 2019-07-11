package com.subsmanagement.subscription.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Subscriber {
    private @Id String email;
    private String firstName;
    private String lastName;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}
