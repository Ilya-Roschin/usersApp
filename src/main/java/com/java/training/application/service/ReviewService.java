package com.java.training.application.service;

import com.java.training.application.dto.ReviewDto;
import com.java.training.application.mapper.ReviewMapper;
import com.java.training.application.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserService userService;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.userService = userService;
    }


    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findAllReviewsByUserId(long userId) {
        return userService.findEntityById(userId)
                .getReviews()
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public void save(final ReviewDto reviewDto) {
        reviewRepository.save(reviewMapper.toEntity(reviewDto));
    }
}
