package com.java.training.application.repository;

import com.java.training.application.entity.Review;
import com.java.training.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<User> findBy(String name);
}
