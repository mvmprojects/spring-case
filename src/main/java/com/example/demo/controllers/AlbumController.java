package com.example.demo.controllers;

import com.example.demo.controllers.dtos.AlbumDto;
import com.example.demo.mappers.AlbumMapper;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity create() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    public ResponseEntity<List<AlbumDto>> read() { return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); }

    @GetMapping("/byartistid")
    public ResponseEntity<List<AlbumDto>> findByArtistId(long artistId) {
        List<AlbumEntity> albumList = albumService.findByArtistId(artistId);
        List<AlbumDto> mappedList = new ArrayList<>();
        for (AlbumEntity e : albumList) {
            mappedList.add(AlbumMapper.albumEntityToAlbumDto(e));
        }
        return new ResponseEntity<>(mappedList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
