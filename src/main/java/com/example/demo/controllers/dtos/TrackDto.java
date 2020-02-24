package com.example.demo.controllers.dtos;

public class TrackDto {
    // to be used with ModelMapper
    private long id;
    private String name;
    private int duration;
    private String albumName;
    private long albumId;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
}
