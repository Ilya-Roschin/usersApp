package com.java.training.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ReviewDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "text is incorrect")
    private String text;

    @NotBlank(message = "songId is incorrect")
    private Long songId;

    @NotBlank(message = "userName is incorrect")
    private String userName;
}
