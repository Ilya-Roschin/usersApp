package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "text is incorrect")
    private String text;

    @NotBlank(message = "song name is incorrect")
    private String songName;

    // TODO: 28.01.2022 remove first - last name USE "userName"
    @NotBlank(message = "song name is incorrect")
    private String userName;
}
