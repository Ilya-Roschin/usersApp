package com.java.training.application.conroller;

import com.java.training.application.dto.SongDto;
import com.java.training.application.service.SongService;
import com.java.training.application.status.Genre;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/songs")
@AllArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public List<SongDto> findAll() {
        return songService.findAll();
    }

    @GetMapping(path = "/{id}")
    public SongDto findById(@PathVariable final long id) {
        return songService.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable("id") final Long id) {
        songService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable final Long id, @RequestBody final String name,
                       @RequestBody final Genre genre, @RequestBody final String album,
                       @RequestBody final String group) {
        songService.update(id, name, genre, album, group);
    }

    @PostMapping
    public void save(@RequestBody final SongDto songDto) {
        songService.save(songDto);
    }
}
