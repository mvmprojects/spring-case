package com.example.demo.repositories.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRACK_ID")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ALBUM_ID")
    private AlbumEntity album;

    @Column(name = "DURATION")
    private int duration;

    public TrackEntity() {

    }

    public TrackEntity(String name, int duration) {
        this.name = name;
        this.duration = duration;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public AlbumEntity getAlbum() {
        return album;
    }
}
