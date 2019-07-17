package com.subsmanagement.dao.impl;

import com.subsmanagement.dao.OrderDao;
import com.subsmanagement.entity.Order;
import com.subsmanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderDaoImpl implements OrderDao {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderDaoImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return this.orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Order> create(Order order) {
        return Optional.ofNullable(this.orderRepository.save(order));
    }
}
