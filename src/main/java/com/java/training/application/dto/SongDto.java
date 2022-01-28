package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SongDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "song name is incorrect")
    private String songName;


}
