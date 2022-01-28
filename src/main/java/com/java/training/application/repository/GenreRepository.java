package com.java.training.application.repository;

import com.java.training.application.entity.Genre;
import com.java.training.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
