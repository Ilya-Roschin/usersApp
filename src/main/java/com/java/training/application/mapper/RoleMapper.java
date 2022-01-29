package com.java.training.application.mapper;

import com.java.training.application.dto.RoleDto;
import com.java.training.application.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleDto toDto(final Role role) {
        final RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRoleName(role.getRoleName());
        return roleDto;
    }

    public Role toEntity(final RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .roleName(roleDto.getRoleName())
                .build();
    }
}

