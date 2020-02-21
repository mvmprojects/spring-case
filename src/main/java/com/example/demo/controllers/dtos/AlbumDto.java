package com.example.demo.controllers.dtos;

public class AlbumDto {
    // not implemented; to be used in controllers for sending to and receiving from frontend
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
