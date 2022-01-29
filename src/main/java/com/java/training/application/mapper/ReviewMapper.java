package com.java.training.application.mapper;

import com.java.training.application.dto.ReviewDto;
import com.java.training.application.entity.Review;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.repository.SongRepository;
import com.java.training.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Component
public class ReviewMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    public ReviewDto toDto(final Review review) {
        final ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setText(review.getText());
        reviewDto.setSongName(review.getSong().getName());
        // TODO: 28.01.2022 remove FirstName USE userName
        reviewDto.setUserName(review.getUser().getFirstName());
        return reviewDto;
    }

    public Review toEntity(final ReviewDto reviewDto) {
        final Review review = new Review();
        review.setId(reviewDto.getId());
        review.setText(reviewDto.getText());
        review.setSong(songRepository.findByName(reviewDto.getSongName()).orElseThrow(() ->
                // TODO: 29.01.2022 create new constant
                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE + reviewDto.getSongName())));
        review.setUser(userRepository.findByFirstName(reviewDto.getUserName()).orElseThrow(() ->
                // TODO: 29.01.2022 create new constant
                new EntityNotFoundException(USER_NOT_FOUND_MESSAGE + reviewDto.getUserName())));
        return review;
    }
}
