package com.java.training.application.conroller;

import com.java.training.application.dto.UserDto;
import com.java.training.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{firstName}")
    public UserDto findByFirstName(@PathVariable String firstName) {
        return userService.findByFirstName(firstName);
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }
}
