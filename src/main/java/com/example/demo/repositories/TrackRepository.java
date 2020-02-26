package com.example.demo.repositories;

import com.example.demo.repositories.entities.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<TrackEntity, Long> {
    List<TrackEntity> findByAlbumId(long id);
}
