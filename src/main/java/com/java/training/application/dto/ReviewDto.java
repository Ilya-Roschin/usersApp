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

    @NotBlank(message = "song id")
    private Long songId;

    @NotBlank(message = "song name is incorrect")
    private String userName;
}
