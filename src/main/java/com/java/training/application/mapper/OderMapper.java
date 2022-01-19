package com.java.training.application.mapper;

import com.java.training.application.dto.OrderDto;
import com.java.training.application.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OderMapper {

    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);
}
