package com.subsmanagement.dao.impl;

import com.subsmanagement.constant.enums.Status;
import com.subsmanagement.dao.OrderDao;
import com.subsmanagement.entity.Order;
import com.subsmanagement.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplTests {

    @Mock
    private OrderRepository mockOrderRepository;
    private OrderDao mockOrderDao;
    private Order order;

    @Before
    public void setUp() {
        this.mockOrderDao = new OrderDaoImpl(this.mockOrderRepository);
        this.order = Order.builder()
                .status(Status.ACTIVE.name())
                .email("test@test.com")
                .date(LocalDateTime.now())
                .createTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
    }

    @Test
    public void findById_happyPath() {
        // Arrange
        int mockId = 1;
        when(this.mockOrderRepository.findById(mockId))
                .thenReturn(Optional.ofNullable(this.order));

        // Act
        Optional<Order> orderReturned = this.mockOrderDao.findById(mockId);

        // Assert
        assertTrue(orderReturned.isPresent());
        assertEquals(this.order, orderReturned.get());
    }

    @Test
    public void create_happyPath() {
        // Arrange
        when(this.mockOrderRepository.save(this.order))
                .thenReturn(this.order);

        // Act
        Optional<Order> orderReturned = this.mockOrderDao.create(this.order);

        // Assert
        assertTrue(orderReturned.isPresent());
        assertEquals(this.order, orderReturned.get());
    }
}
