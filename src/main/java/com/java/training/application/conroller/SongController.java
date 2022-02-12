package com.java.training.application.conroller;

import com.java.training.application.dto.SongDto;
import com.java.training.application.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public void save(@RequestBody final SongDto songDto) {
        songService.save(songDto);
    }
}
