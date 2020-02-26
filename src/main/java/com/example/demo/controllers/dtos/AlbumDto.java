package com.example.demo.controllers.dtos;

public class AlbumDto {

    private long id;
    private String name;
    private long artistId;
    private String artistName;

    public AlbumDto() {
    }

    public AlbumDto(long id, String name, long artistId, String artistName) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.artistName = artistName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
