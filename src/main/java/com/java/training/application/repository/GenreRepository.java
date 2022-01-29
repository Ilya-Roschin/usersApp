package com.java.training.application.repository;

import com.java.training.application.entity.Genre;
import com.java.training.application.entity.Song;
import com.java.training.application.entity.User;
import com.java.training.application.status.GenreEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Optional<Genre> findByGenre(GenreEnum genre);
}
