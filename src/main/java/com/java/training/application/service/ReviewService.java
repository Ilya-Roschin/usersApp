package com.java.training.application.service;

import com.java.training.application.dto.ReviewDto;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.mapper.ReviewMapper;
import com.java.training.application.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private UserService userService;


    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findAllReviewsByUserId(final long userId) {
        return userService.findEntityById(userId)
                .getReviews()
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReviewDto findById(final long id) {
        return reviewMapper.toDto(reviewRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE)));
    }

    @Transactional
    public void deleteById(final Long id) {
        reviewRepository.deleteById(id);
    }

    public void save(final ReviewDto reviewDto) {
        reviewRepository.save(reviewMapper.toEntity(reviewDto));
    }
}
