package com.java.training.application.service;

import com.java.training.application.dto.UserDto;
import com.java.training.application.entity.User;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.mapper.UserMapper;
import com.java.training.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto findByUsername(final String firstName) {
        return userMapper.toDto(userRepository.findByUsername(firstName)
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND_MESSAGE + firstName)));
    }

    public User findEntityById(final long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND_MESSAGE));
    }

    public void save(final UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }
}
