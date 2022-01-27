package com.java.training.application.service;

import com.java.training.application.dto.RoleDto;
import com.java.training.application.mapper.RoleMapper;
import com.java.training.application.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;



    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(RoleMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
