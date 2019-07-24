package com.subsmanagement.dao;

import com.subsmanagement.entity.Period;

import java.util.Optional;

public interface PeriodDao {

    Optional<Period> findById(Integer id);

    Optional<Period> create(Period period);
}
