package com.subsmanagement.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ServiceProvider {
    private @Id Long id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}
