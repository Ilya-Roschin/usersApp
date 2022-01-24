package com.java.training.application.mapper;

import com.java.training.application.dto.UserDto;
import com.java.training.application.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
