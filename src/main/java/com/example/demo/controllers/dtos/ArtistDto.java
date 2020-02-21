package com.example.demo.controllers.dtos;

public class ArtistDto {
    // not implemented; to be used in controllers for sending to and receiving from frontend
    private long id;
    private String name;

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
