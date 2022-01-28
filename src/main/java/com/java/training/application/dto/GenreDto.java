package com.java.training.application.dto;

import com.java.training.application.status.GenreEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GenreDto {

    @NotBlank(message = "id is incorrect")
    private int id;

    @NotBlank(message = "genre is incorrect")
    private GenreEnum genre;
}
