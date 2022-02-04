package com.java.training.application.dto;

import com.java.training.application.status.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
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
    private Genre genre;

    private List<Long> reviewIds;

    private List<Long> orderIds;
}
