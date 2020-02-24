package com.example.demo.repositories.entities;

import javax.persistence.*;

@Entity
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRACK_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ALBUM_ID")
    private AlbumEntity album;

    @Column(name = "DURATION")
    private int duration;

    public TrackEntity() {

    }

    public TrackEntity(String name, AlbumEntity album, int duration) {
        this.name = name;
        this.album = album;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

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

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }
}
