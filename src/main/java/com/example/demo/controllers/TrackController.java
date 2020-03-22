package com.example.demo.controllers;

import com.example.demo.controllers.dtos.TrackDto;
import com.example.demo.mappers.TrackMapper;
import com.example.demo.repositories.entities.TrackEntity;
import com.example.demo.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public ResponseEntity<TrackDto> create(@RequestBody TrackDto trackDto) {
        TrackEntity createdTrack = trackService.create(TrackMapper.trackDtoToTrackEntity(trackDto));
        if (createdTrack != null) {
            TrackDto returnTrack = TrackMapper.trackEntityToTrackDto(createdTrack);
            return new ResponseEntity<>(returnTrack, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<List<TrackDto>> read() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/byalbumid/{albumId}")
    public ResponseEntity<List<TrackDto>> findByAlbumId(@PathVariable Long albumId) {
        List<TrackEntity> trackList = trackService.findByAlbumId(albumId);
        List<TrackDto> mappedList = new ArrayList<>();
        for (TrackEntity e : trackList) {
            mappedList.add(TrackMapper.trackEntityToTrackDto(e));
        }
        return new ResponseEntity<>(mappedList, HttpStatus.OK);
    }

    @PutMapping//("/{id}")
    public ResponseEntity<TrackDto> update(@RequestBody TrackDto trackDto) {
        TrackEntity updatedTrack = trackService.update(TrackMapper.trackDtoToTrackEntity(trackDto));
        if (updatedTrack != null) {
            TrackDto returnTrack = TrackMapper.trackEntityToTrackDto(updatedTrack);
            return new ResponseEntity<>(returnTrack, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackService.delete(id);
    }
}
