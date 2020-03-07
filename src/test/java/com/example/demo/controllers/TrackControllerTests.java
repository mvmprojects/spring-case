package com.example.demo.controllers;

import com.example.demo.controllers.dtos.TrackDto;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;
import com.example.demo.services.TrackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TrackController.class)
public class TrackControllerTests {

    private TrackController trackController;

    @MockBean
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
        assertThat(result.getBody().getId(), is(10L));
    }

    @Test
    public void shouldFindTracksByAlbumId() {
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

        List<TrackEntity> list = new ArrayList<>();
        list.add(trackEntity);

        when(trackService.findByAlbumId(ArgumentMatchers.anyLong())).thenReturn(list);

        var result = trackController.findByAlbumId(10L);

        assertThat(result, is(notNullValue()));
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
        assertThat(result.getBody(), is(notNullValue()));
        assertThat(result.getBody().get(0).getId(), is(10L));
    }

    @Test
    public void shouldUpdateTrack() {
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

        when(trackService.update(ArgumentMatchers.any())).thenReturn(trackEntity);

        TrackDto trackDto = new TrackDto();
        trackDto.setId(trackEntity.getId());
        trackDto.setName(trackEntity.getName());
        trackDto.setAlbumId(trackEntity.getAlbum().getId());
        trackDto.setAlbumName(trackEntity.getAlbum().getName());
        trackDto.setArtistId(trackEntity.getAlbum().getArtist().getId());
        trackDto.setArtistName(trackEntity.getAlbum().getArtist().getName());
        trackDto.setDuration(trackEntity.getDuration());

        var result = trackController.update(trackDto);

        assertThat(result, is(notNullValue()));
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
        assertThat(result.getBody(), is(notNullValue()));
        assertThat(result.getBody().getId(), is(10L));
    }

    @Test
    public void shouldDeleteTrack() {
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

        trackController.delete(trackDto);

        var getList = trackController.findByAlbumId(10L);

        assertThat(getList.getBody(), is(notNullValue()));
        assertThat(getList.getBody().size(), is(0));
    }
}
