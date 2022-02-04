package com.java.training.application.mapper;

import com.java.training.application.dto.UserDto;
import com.java.training.application.entity.Order;
import com.java.training.application.entity.Review;
import com.java.training.application.entity.User;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.repository.OrderRepository;
import com.java.training.application.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private OrderRepository orderRepository;

    public UserDto toDto(final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userDto.setReviewIds(user.getReviews().stream()
                .map(Review::getId)
                .collect(Collectors.toList()));
        userDto.setOrderIds(user.getOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return userDto;
    }

    public User toEntity(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .role(userDto.getRole())
                .reviews(userDto.getOrderIds().stream()
                        .map(orderId -> reviewRepository.findById(orderId).orElseThrow(EntityNotFoundException::new))
                        .collect(Collectors.toSet()))
                .build();
    }
}
