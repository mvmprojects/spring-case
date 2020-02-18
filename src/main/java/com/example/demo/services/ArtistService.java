package com.example.demo.services;

import com.example.demo.repositories.ArtistRepository;
import com.example.demo.repositories.entities.ArtistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<ArtistEntity> findAll() {
        return artistRepository.findAll();
    }

    public ArtistEntity findByName(String name) {
        return artistRepository.findByName(name);
    }
}
