package com.example.demo.services;

import com.example.demo.repositories.TrackRepository;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.TrackEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackEntity save(TrackEntity trackEntity) {
        return (TrackEntity) trackRepository.save(trackEntity);
    }

    public Optional<TrackEntity> findById(long id) {
        return trackRepository.findById(id);
    }

    public List<TrackEntity> findByAlbum(AlbumEntity album) {
        return trackRepository.findByAlbum(album);
    }

    public TrackEntity update(TrackEntity trackEntity) {
        return (TrackEntity) trackRepository.save(trackEntity);
    }

    public void delete(Long id) {
        trackRepository.deleteById(id);
    }
}
