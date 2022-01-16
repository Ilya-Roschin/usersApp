package com.java.training.application.repository;

import com.java.training.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstName(String name);
    // TODO: 16.01.2022 if you can not find any entity throw EnNFE
    // TODO: 16.01.2022 return Optional
}

