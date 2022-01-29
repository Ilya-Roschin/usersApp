package com.java.training.application.mapper;

import com.java.training.application.dto.GenreDto;
import com.java.training.application.entity.Genre;
import com.java.training.application.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    @Autowired
    private GenreRepository genreRepository;

    public GenreDto toDto(final Genre genre) {
        final GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setGenre(genre.getGenre());
        return genreDto;
    }

    public Genre toEntity(final GenreDto genreDto) {
        return Genre.builder()
                .id(genreDto.getId())
                .genre(genreDto.getGenre())
                .build();
    }
}
