package com.example.demo.controllers;

import com.example.demo.controllers.dtos.AlbumDto;
import com.example.demo.controllers.dtos.ArtistDto;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.services.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.OK;

public class AlbumControllerTests {

    private AlbumController albumController;

    private AlbumService albumService;

    @BeforeEach
    public void setup() throws Exception {
        albumService = mock(AlbumService.class);

        albumController = new AlbumController(albumService);
    }

    @Test
    public void findByArtistIdTest() throws Exception {
        // given
        ArtistDto artistDto = new ArtistDto();
        artistDto.setName("artist");
        artistDto.setId(1L);
        ArtistEntity artistEntity = mock(ArtistEntity.class);
        AlbumEntity album = new AlbumEntity();
        album.setId(1L);
        album.setArtist(artistEntity);
        album.setName("album");

        List<AlbumEntity> albumEntityList = Arrays.asList(album, album);
        given(albumService.findByArtistId(anyLong())).willReturn(albumEntityList);
//        given(mapperMock.map(any(AlbumEntity.class), AlbumDto.class)).willReturn(albumDto);

        // when
        var resultList = albumController.findByArtistId(1L);

        // then
        assertThat(resultList, is(notNullValue()));
        assertThat(resultList.getStatusCode(), is(OK));
        assertThat(resultList.getBody().get(0), is(notNullValue()));
    }
}
