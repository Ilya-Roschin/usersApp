package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SongDto {

    @NotBlank(message = "id is incorrect")
    private long id;

    @NotBlank(message = "song name is incorrect")
    private String songName;

    @NotBlank(message = "group id is incorrect")
    private String groupName;

    @NotBlank(message = "album name is incorrect")
    private String albumName;
}
