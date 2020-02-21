package com.example.demo.controllers.dtos;

public class TrackDto {
    // not implemented; to be used in controllers for sending to and receiving from frontend
    private long id;
    private String title;
    private int duration;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
