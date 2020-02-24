package com.example.demo.repositories.entities;

import javax.persistence.*;

@Entity
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALBUM_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID", nullable = false, referencedColumnName = "ID")
    private ArtistEntity artist;

    public AlbumEntity() {
    }

    public AlbumEntity(String name, ArtistEntity artist) {
        this.name = name;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
}
