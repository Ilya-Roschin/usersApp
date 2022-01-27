package com.java.training.application.mapper;

import com.java.training.application.dto.ReviewDto;
import com.java.training.application.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewDto toDto(Review review);

    Review toEntity(ReviewDto review);
}
