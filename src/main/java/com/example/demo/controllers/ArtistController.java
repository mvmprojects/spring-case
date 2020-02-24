package com.example.demo.controllers;

import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.services.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ModelMapper modelMapper;

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
    public ResponseEntity<List<ArtistEntity>> read() { return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); }

    @GetMapping("/byname")
    public ResponseEntity<ArtistEntity> findByName(String name) {
        ArtistEntity artistEntity = artistService.findByName(name);
        // should use a mapper at this point so entity object can be converted to dto object before returning
        if (artistEntity != null) {
            return new ResponseEntity<>(artistEntity, HttpStatus.OK);
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
