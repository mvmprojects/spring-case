package com.example.demo.controllers;

import com.example.demo.controllers.dtos.TrackDto;
import com.example.demo.mappers.TrackMapper;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;
import com.example.demo.services.TrackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

public class TrackControllerTests {

    private TrackController trackController;

    private TrackService trackService;

    @BeforeEach
    public void setup() throws Exception {
        trackService = mock(TrackService.class);

        trackController = new TrackController(trackService);
    }

    @Test
    public void shouldCreateTrack() {
        TrackEntity trackEntity = new TrackEntity();
        trackEntity.setId(10L);
        trackEntity.setName("");
        trackEntity.setDuration(1);

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setId(10L);
        albumEntity.setName("");

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setId(10L);
        artistEntity.setName("");

        albumEntity.setArtist(artistEntity);
        trackEntity.setAlbum(albumEntity);
//        given(mapperMock.map(any(TrackDto.class), TrackEntity.class)).willReturn(trackEntity);
//        given(mapperMock.map(any(TrackEntity.class), TrackDto.class)).willReturn(trackDto);

        when(trackService.create(ArgumentMatchers.any())).thenReturn(trackEntity);

        TrackDto trackDto = new TrackDto();
        trackDto.setId(trackEntity.getId());
        trackDto.setName(trackEntity.getName());
        trackDto.setAlbumId(trackEntity.getAlbum().getId());
        trackDto.setAlbumName(trackEntity.getAlbum().getName());
        trackDto.setArtistId(trackEntity.getAlbum().getArtist().getId());
        trackDto.setArtistName(trackEntity.getAlbum().getArtist().getName());
        trackDto.setDuration(trackEntity.getDuration());

        var result = trackController.create(trackDto);

        assertThat(result, is(notNullValue()));
        assertThat(result.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(result.getBody(), is(notNullValue()));
    }

    @Test
    public void shouldFindTracksByAlbumId() {

    }

    @Test
    public void shouldUpdateTrack() {

    }

    @Test
    public void shouldDeleteTrack() {

    }
}
