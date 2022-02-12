package com.java.training.application.conroller;

import com.java.training.application.dto.ReviewDto;
import com.java.training.application.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ReviewDto findById(@PathVariable final long id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody final ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }
}
