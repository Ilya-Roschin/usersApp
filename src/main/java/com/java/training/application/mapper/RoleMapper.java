package com.java.training.application.mapper;

import com.java.training.application.dto.RoleDto;
import com.java.training.application.entity.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);
}
