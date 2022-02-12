package com.java.training.application.conroller;

import com.java.training.application.dto.SongDto;
import com.java.training.application.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(final SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<SongDto> findAll() {
        return songService.findAll();
    }

    @GetMapping(path = "/{id}")
    public SongDto findById(@PathVariable final long id) {
        return songService.findById(id);
    }
}
