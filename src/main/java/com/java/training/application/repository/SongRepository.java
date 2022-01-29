package com.java.training.application.repository;

import com.java.training.application.entity.Song;
import com.java.training.application.entity.Status;
import com.java.training.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<Song> findByName(String name);
}
