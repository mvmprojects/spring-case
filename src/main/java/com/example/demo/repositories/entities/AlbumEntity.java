package com.example.demo.repositories.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @OneToMany(mappedBy = "id")
    private List<TrackEntity> trackEntityList;

    public AlbumEntity() {
    }

    public AlbumEntity(String name, ArtistEntity artist, List<TrackEntity> trackEntityList) {
        this.name = name;
        this.artist = artist;
        this.trackEntityList = trackEntityList;
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

    public List<TrackEntity> getTrackEntityList() {
        return trackEntityList;
    }

    public void setTrackEntityList(List<TrackEntity> trackEntityList) {
        this.trackEntityList = trackEntityList;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
}
