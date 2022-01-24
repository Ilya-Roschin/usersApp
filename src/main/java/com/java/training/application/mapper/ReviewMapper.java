package com.java.training.application.mapper;

import com.java.training.application.dto.ReviewDto;
import com.java.training.application.entity.Review;
import org.mapstruct.Mapper;

@Mapper
public interface ReviewMapper {

    ReviewDto toDto(Review review);

    Review toEntity(ReviewDto review);
}
