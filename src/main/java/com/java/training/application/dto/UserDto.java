package com.java.training.application.dto;

import com.java.training.application.entity.Review;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class UserDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "firstName is incorrect")
    private String firstName;

    @NotBlank(message = "lastName is incorrect")
    private String lastName;

    private RoleEnum role;

    private Set<Review> reviews;
}
