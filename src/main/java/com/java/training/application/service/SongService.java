package com.java.training.application.service;

import com.java.training.application.dto.SongDto;
import com.java.training.application.entity.Song;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.mapper.SongMapper;
import com.java.training.application.repository.SongRepository;
import com.java.training.application.status.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void update(final Long id, final String name, final Genre genre, final String album, final String group) {
        final Song song = songRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE));
        song.setGenre(genre);
        song.setAlbum(album);
        song.setName(name);
    }

    @Transactional
    public void deleteById(final Long id) {
        songRepository.deleteById(id);
    }

    public void save(final SongDto songDto) {
        songRepository.save(songMapper.toEntity(songDto));
    }

}
