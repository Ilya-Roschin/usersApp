package com.java.training.application.mapper;

import com.java.training.application.status.RoleEnum;
import com.java.training.application.dto.UserDto;
import com.java.training.application.entity.Role;
import com.java.training.application.entity.User;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.repository.RoleRepository;
import org.springframework.stereotype.Component;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Component
public class UserMapper {

    // TODO: 27.01.2022 remove userRepository!!!!!! 
    // TODO: 27.01.2022 use another tool
    private final RoleRepository roleRepository;

    public UserMapper(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public UserDto toDto(final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        userDto.setRole(user.getRole().getRoleName());
        userDto.setReviews(user.getReviews());
        return userDto;
    }

    public User toEntity(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(findRoleIdByRoleName(userDto.getRole()))
                .reviews(userDto.getReviews())
                .build();
    }

    public Role findRoleIdByRoleName(final RoleEnum roleEnum) {
        switch (roleEnum) {
            case ADMIN:
                return roleRepository.findById(1L)
                        .orElseThrow(() ->
                                // TODO: 27.01.2022 remove User_not found -> role not found 
                                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE));
            default:
               return roleRepository.findById(2L)
                        .orElseThrow(() ->
                                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE));
        }
    }
}
