package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GenreDto {

    @NotBlank(message = "id is incorrect")
    private long id;

    @NotBlank(message = "genre name is incorrect")
    private String genreName;
}
