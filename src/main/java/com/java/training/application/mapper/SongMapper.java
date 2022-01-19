package com.java.training.application.mapper;

import com.java.training.application.dto.SongDto;
import com.java.training.application.entity.Song;
import org.mapstruct.Mapper;

@Mapper
public interface SongMapper {

    SongDto toDto(Song song);

    Song toEntity(SongDto songDto);
}
