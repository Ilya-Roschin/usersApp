package com.java.training.application.service;

import com.java.training.application.dto.UserDto;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.mapper.UserMapper;
import com.java.training.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository, final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto findByFirstName(final String firstName) {
        return userMapper.toDto(userRepository.findByFirstName(firstName)
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND_MESSAGE + firstName)));
    }

    public void save(final UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }
}
