package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "id is incorrect")
    private String id;

    @NotBlank(message = "first name is incorrect")
    private String firstName;

    @NotBlank(message = "last name is incorrect")
    private String lastName;

    @NotBlank(message = "login is incorrect")
    private String login;

    @NotBlank(message = "password is incorrect")
    private String password;
}
