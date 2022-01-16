package com.java.training.application.conroller;

import com.java.training.application.dto.UserDto;
import com.java.training.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/testResponseStatusException")
//    public Response testResponseStatusException(@RequestParam(required = false, defaultValue = "false") boolean exception) {
//        if (exception) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ResponseStatusException in testResponseStatusException");
//        }
//        return new Response("OK");
//    }

    @GetMapping
    public List<UserDto> findAll() {
        log.info("Execute method findAll");
        return userService.findAll();
    }

    @GetMapping(path = "/{firstName}")
    public UserDto findByFirstName(@PathVariable String firstName) {
        log.info("Execute method findByFirstName");
        return userService.findByFirstName(firstName);
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        log.info("Execute method save");
        userService.save(userDto);
    }
}
