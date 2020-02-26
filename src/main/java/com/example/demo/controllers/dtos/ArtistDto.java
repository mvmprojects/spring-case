package com.example.demo.controllers.dtos;

public class ArtistDto {

    private long id;
    private String name;

    public ArtistDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistDto() {
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
}
