package com.java.training.application.service;

import com.java.training.application.dto.SongDto;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.mapper.SongMapper;
import com.java.training.application.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public SongService(SongRepository songRepository, SongMapper songMapper) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
    }

    public List<SongDto> findAll() {
        return songRepository.findAll().stream()
                .map(songMapper::toDto)
                .collect(Collectors.toList());
    }

    public SongDto findByName(final String name) {
        return songMapper.toDto(songRepository.findByName(name)
                .orElseThrow(() ->
                        new EntityNotFoundException(USER_NOT_FOUND_MESSAGE)));
    }

    public void save(final SongDto songDto) {
        songRepository.save(songMapper.toEntity(songDto));
    }
}
