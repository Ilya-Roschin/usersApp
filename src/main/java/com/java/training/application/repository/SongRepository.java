package com.java.training.application.repository;

import com.java.training.application.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Optional<Song>> findAllByName(String name);

    Optional<Song> findByName(String name);
}
