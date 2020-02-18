package com.example.demo.controllers;

import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.TrackEntity;
import com.example.demo.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    // dto objects not yet implemented; should send and receive dto objects instead of entity objects

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public ResponseEntity<TrackEntity> create(TrackEntity trackEntity) {
        TrackEntity createdTrack = trackService.save(trackEntity);
        return new ResponseEntity<>(createdTrack, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrackEntity>> read() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/byalbum")
    public ResponseEntity<List<TrackEntity>> findByAlbum(AlbumEntity album) {
        List<TrackEntity> trackList = trackService.findByAlbum(album);
        return new ResponseEntity<>(trackList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(TrackEntity trackEntity) {
        TrackEntity updatedTrack = trackService.update(trackEntity);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(TrackEntity trackEntity) {
        trackService.delete(trackEntity.getId());
    }
}
