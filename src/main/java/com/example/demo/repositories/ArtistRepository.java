package com.example.demo.repositories;

import com.example.demo.repositories.entities.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    ArtistEntity findByName(String name);
}
