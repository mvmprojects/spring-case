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

    @NotNull
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID", nullable = false, referencedColumnName = "ID")
    private ArtistEntity artist;

    @OneToMany(mappedBy = "id")
    private List<TrackEntity> trackEntityList;

    public AlbumEntity() {
    }

    public AlbumEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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
}
