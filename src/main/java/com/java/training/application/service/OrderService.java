package com.java.training.application.service;

import com.java.training.application.dto.OrderDto;
import com.java.training.application.entity.Order;
import com.java.training.application.entity.Song;
import com.java.training.application.mapper.OrderMapper;
import com.java.training.application.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderMapper orderMapper;

    public void findFinalPrice(final Order order) {
        final BigDecimal finalPrice = new BigDecimal("0");
        order.getSongs().stream()
                .map(Song::getPrice)
                .forEach(finalPrice::add);
                order.setFinalPrice(finalPrice.setScale(2, RoundingMode.CEILING));
    }

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<OrderDto> findAllOrdersByUserId(final long userId) {
        return userService.findEntityById(userId)
                .getOrders()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public void save(final OrderDto orderDto) {
        orderRepository.save(orderMapper.toEntity(orderDto));
    }
}

