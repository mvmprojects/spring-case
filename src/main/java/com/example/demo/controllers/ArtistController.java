package com.example.demo.controllers;

import com.example.demo.controllers.dtos.ArtistDto;
import com.example.demo.mappers.ArtistMapper;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity create() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    public ResponseEntity<List<ArtistDto>> read() { return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); }

    @GetMapping("/byname")
    public ResponseEntity<ArtistDto> findByName(String name) {
        ArtistEntity artistEntity = artistService.findByName(name);
        if (artistEntity != null) {
            // use mapper to convert to dto
            ArtistDto artistDto = ArtistMapper.artistEntityToArtistDto(artistEntity);
            return new ResponseEntity<>(artistDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
