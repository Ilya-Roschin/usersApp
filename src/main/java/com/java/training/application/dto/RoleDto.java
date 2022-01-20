package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoleDto {

    @NotBlank(message = "id is incorrect")
    private long id;

    @NotBlank(message = "name is incorrect")
    private String name;

}
