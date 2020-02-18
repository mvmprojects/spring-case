package com.example.demo.services;

import com.example.demo.repositories.AlbumRepository;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public AlbumEntity save(AlbumEntity albumEntity) {
        return (AlbumEntity) albumRepository.save(albumEntity);
    }

    public Optional<AlbumEntity> findById(long id) {
        return albumRepository.findById(id);
    }

    public List<AlbumEntity> findByArtistId(long id) {
        return albumRepository.findByArtistId(id);
    }

    public AlbumEntity update(AlbumEntity albumEntity) {
        return (AlbumEntity) albumRepository.save(albumEntity);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}