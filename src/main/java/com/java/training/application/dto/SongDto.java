package com.java.training.application.dto;

import com.java.training.application.status.GenreEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SongDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "song name is incorrect")
    private String songName;

    @NotBlank(message = "group is incorrect")
    private String group;

    @NotBlank(message = "album is incorrect")
    private String album;

    @NotBlank(message = "price is incorrect")
    private BigDecimal price;

    @NotBlank(message = "genreEnum is incorrect")
    private GenreEnum genreEnum;

    // TODO: 31.01.2022 костыль)
    @NotBlank(message = "review is incorrect")
    private List<Long> reviewsId;
}
