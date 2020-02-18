package com.example.demo.repositories;

import com.example.demo.repositories.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    List<AlbumEntity> findByArtistId(long id);
}
