package com.java.training.application.repository;

import com.java.training.application.entity.Song;
import com.java.training.application.entity.Status;
import com.java.training.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Status, Integer> {

    Optional<Song> findByName(String name);
}
