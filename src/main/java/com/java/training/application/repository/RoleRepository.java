package com.java.training.application.repository;

import com.java.training.application.entity.Role;
import com.java.training.application.entity.User;
import com.java.training.application.status.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(RoleEnum roleName);
}
