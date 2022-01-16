package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "id is incorrect")
    private String id;

    @NotBlank(message = "firstName is incorrect")
    private String firstName;

    @NotBlank(message = "lastName is incorrect")
    private String lastName;
}
