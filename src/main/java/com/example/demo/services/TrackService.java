package com.example.demo.services;

import com.example.demo.repositories.TrackRepository;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.TrackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    @Autowired
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackEntity create(TrackEntity trackEntity) {
        return trackRepository.save(trackEntity);
    }

    public List<TrackEntity> findAll() { return trackRepository.findAll(); }

    public Optional<TrackEntity> findById(long id) {
        return trackRepository.findById(id);
    }

    public List<TrackEntity> findByAlbumId(long id) {
        return trackRepository.findByAlbumId(id);
    }

    public TrackEntity update(TrackEntity trackEntity) {
        return trackRepository.save(trackEntity);
    }

    public void delete(Long id) {
        trackRepository.deleteById(id);
    }

    public void deleteAll() { trackRepository.deleteAll();}
}
