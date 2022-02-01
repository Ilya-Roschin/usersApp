package com.java.training.application.service;

import com.java.training.application.dto.SongDto;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.mapper.SongMapper;
import com.java.training.application.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongMapper songMapper;

    public List<SongDto> findAll() {
        return songRepository.findAll().stream()
                .map(songMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<SongDto> findAllByName(final String name) {
        return songRepository.findAllByName(name).stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(songMapper::toDto)
                .collect(Collectors.toList());
    }

    public SongDto findById(final long id) {
        return songMapper.toDto(songRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE)));
    }

    public void save(final SongDto songDto) {
        songRepository.save(songMapper.toEntity(songDto));
    }

}
