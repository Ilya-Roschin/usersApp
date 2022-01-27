package com.java.training.application.mapper;

import com.java.training.application.dto.RoleDto;
import com.java.training.application.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);
}
