package com.java.training.application.conroller;

import com.java.training.application.dto.UserDto;
import com.java.training.application.service.UserService;
import com.java.training.application.status.Role;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{id}")
    public UserDto findById(@PathVariable final long id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/username/{username}")
    public UserDto findByFirstName(@PathVariable final String username) {
        return userService.findByUsername(username);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable("id") final Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping("username/{username}")
    public void deleteByUsername(@PathVariable("username") final String username) {
        userService.deleteByUsername(username);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable final Long id, @RequestBody final String username, @RequestBody final Role role) {
        userService.update(id, username, role);
    }

    @PostMapping
    public void save(@RequestBody final UserDto userDto) {
        userService.save(userDto);
    }
}
