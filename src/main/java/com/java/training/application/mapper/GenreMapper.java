package com.java.training.application.mapper;

import com.java.training.application.dto.GenreDto;
import com.java.training.application.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public GenreDto toDto(final Genre genre) {
        final GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setGenre(genre.getGenre());
        return genreDto;
    }
}
