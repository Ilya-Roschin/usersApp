package com.java.training.application.mapper;

import com.java.training.application.dto.PriceDto;
import com.java.training.application.entity.Price;
import org.mapstruct.Mapper;

@Mapper
public interface PriceMapper {

    PriceDto toDto(Price price);

    Price toEntity(PriceDto priceDto);
}
