package com.example.demo.controllers;

import com.example.demo.controllers.dtos.ArtistDto;

import java.util.List;

public class ArtistRequestWrapper {
    List<ArtistDto> results;
    int total;

    public ArtistRequestWrapper(List<ArtistDto> results, int total) {
        this.results = results;
        this.total = total;
    }

    public List<ArtistDto> getResults() {
        return results;
    }

    public void setResults(List<ArtistDto> results) {
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
