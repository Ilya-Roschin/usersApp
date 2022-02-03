package com.java.training.application.mapper;

import com.java.training.application.dto.UserDto;
import com.java.training.application.entity.Review;
import com.java.training.application.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class UserMapper {

    public UserDto toDto(final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());

        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        final List<Review> foundedReviews = new ArrayList<>(user.getReviews());
        userDto.setReviews(foundedReviews);
        return userDto;
    }

    public User toEntity(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .role(userDto.getRole())
                .reviews((Set<Review>) userDto.getReviews())
                .build();
    }
}
