package com.example.demo.services;

import com.example.demo.repositories.AlbumRepository;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public AlbumEntity create(AlbumEntity albumEntity) {
        return albumRepository.save(albumEntity);
    }

    public Optional<AlbumEntity> findById(long id) {
        return albumRepository.findById(id);
    }

    public List<AlbumEntity> findByArtistId(long id) {
        return albumRepository.findByArtistId(id);
    }

    public AlbumEntity update(AlbumEntity albumEntity) {
        return albumRepository.save(albumEntity);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}