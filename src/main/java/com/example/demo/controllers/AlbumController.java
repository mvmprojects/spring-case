package com.example.demo.controllers;

import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<AlbumEntity>> read() { return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED); }

    @GetMapping("/byartist")
    public ResponseEntity<List<AlbumEntity>> findByArtist(ArtistEntity artist) {
        List<AlbumEntity> albumList = albumService.findByArtistId(artist.getId());
        // should use a mapper at this point to convert object to dto before returning
        return new ResponseEntity(albumList, HttpStatus.OK);
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
