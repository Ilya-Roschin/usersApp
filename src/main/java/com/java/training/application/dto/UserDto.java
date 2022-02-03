package com.java.training.application.dto;

import com.java.training.application.entity.Review;
import com.java.training.application.status.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "username is incorrect")
    private String username;

    private Role role;

    private List<Review> reviews;
}
