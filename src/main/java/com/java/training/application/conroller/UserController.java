package com.java.training.application.conroller;

import com.java.training.application.dto.UserDto;
import com.java.training.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{firstName}")
    public UserDto findByFirstName(@PathVariable final String firstName) {
        return userService.findByFirstName(firstName);
    }

    @PostMapping
    public void save(@RequestBody final UserDto userDto) {
        userService.save(userDto);
    }
}
