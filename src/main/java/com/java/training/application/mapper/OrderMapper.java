package com.java.training.application.mapper;

import com.java.training.application.dto.OrderDto;
import com.java.training.application.entity.Order;
import com.java.training.application.entity.Song;

import java.util.stream.Collectors;

public class OrderMapper {

    public OrderDto toDto(final Order order) {
        final OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setSongIds(order.getSongs().stream()
                .map(Song::getId).collect(Collectors.toList()));
        //orderDto.setFinalPrice(ge);
        orderDto.setUserId(order.getUser().getId());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }
}
