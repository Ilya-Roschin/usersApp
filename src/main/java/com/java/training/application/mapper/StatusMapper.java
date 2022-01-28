package com.java.training.application.mapper;

import com.java.training.application.dto.StatusDto;
import com.java.training.application.entity.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public StatusDto toDto(final Status status) {
        final StatusDto statusDto = new StatusDto();
        statusDto.setId(status.getId());
        statusDto.setStatus(status.getStatus());
        return statusDto;
    }
}
