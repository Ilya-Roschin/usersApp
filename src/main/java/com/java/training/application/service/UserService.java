package com.java.training.application.service;

import com.java.training.application.dto.UserDto;
import com.java.training.application.mapper.UserMapper;
import com.java.training.application.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public UserDto findByFirstName(String firstName) {
        log.info("Executing method findByFirstName");
        return UserMapper.INSTANCE.toDto(userRepository.findByFirstName(firstName));
    }

    public void save(UserDto userDto) {
        log.info("Executing method save");
        userRepository.save(UserMapper.INSTANCE.toEntity(userDto));
    }
}
