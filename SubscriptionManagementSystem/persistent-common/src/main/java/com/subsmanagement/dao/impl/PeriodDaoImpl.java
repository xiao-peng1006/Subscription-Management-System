package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.PeriodDao;
import com.subsmanagement.entity.Period;
import com.subsmanagement.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PeriodDaoImpl implements PeriodDao {

    private final PeriodRepository periodRepository;

    @Autowired
    public PeriodDaoImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Override
    public Optional<Period> findById(Integer id) {
        return this.periodRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Period> create(Period period) {
        return Optional.ofNullable(this.periodRepository.save(period));
    }
}
