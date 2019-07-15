package com.subsmanagement.dao.impl;

import com.subsmanagement.PersistentCommonTests;
import com.subsmanagement.constant.enums.Status;
import com.subsmanagement.dao.OrderDao;
import com.subsmanagement.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderDaoImplIntegrationTests extends PersistentCommonTests {

    @Autowired
    private OrderDao orderDao;

    private Order order;

    @Before
    public void setUp() {
        order = Order.builder()
                .date(LocalDateTime.now())
                .status(Status.ACTIVE.name())
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .subscriptionId(1)
                .email("test@test.com")
                .subscriptionPlanId(1)
                .build();
    }

    @Test
    @Transactional
    public void findOrderById_withAValidOrderId_shouldReturnAValidOrder() {
        // Arrange
        Optional<Order> newOrder = this.orderDao.create(this.order);

        // Act
        Optional<Order> orderReturned = this.orderDao.findById(newOrder.get().getId());

        // Assert
        assertTrue(orderReturned.isPresent());
        assertEquals(this.order, orderReturned.get());
    }

    @Test
    @Transactional
    public void createOrder_withValidData_shouldReturnAValidOrder() {
        // Arrange

        // Act
        Optional<Order> orderReturned = this.orderDao.create(this.order);

        // Assert
        assertTrue(orderReturned.isPresent());
        assertEquals(this.order, orderReturned.get());
    }
}
