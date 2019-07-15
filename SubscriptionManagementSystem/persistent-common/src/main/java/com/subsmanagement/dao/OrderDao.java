package com.subsmanagement.dao;

import com.subsmanagement.entity.Order;

import java.util.Optional;

public interface OrderDao {

    Optional<Order> findById(Integer id);

    Optional<Order> create(Order order);
}
