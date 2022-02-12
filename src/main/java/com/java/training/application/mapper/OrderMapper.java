package com.java.training.application.mapper;

import com.java.training.application.dto.OrderDto;
import com.java.training.application.entity.Order;
import com.java.training.application.entity.Song;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.repository.SongRepository;
import com.java.training.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;


    public OrderDto toDto(final Order order) {
        final OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setSongIds(order.getSongs().stream()
                .map(Song::getId).collect(Collectors.toList()));
        orderDto.setFinalPrice(order.getFinalPrice());
        orderDto.setUserId(order.getUser().getId());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }

    public Order toEntity(final OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .status(orderDto.getStatus())
                .finalPrice(orderDto.getFinalPrice())
                .user(userRepository.findById(orderDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND_MESSAGE)))
                .songs(songRepository.findAllById(orderDto.getSongIds()))
                .build();
    }
}
