package com.example.demo.controllers;

import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.services.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration
public class AlbumControllerTests {

    @InjectMocks
    private AlbumController albumController;

    @Mock
    private AlbumService albumService;

    @Mock
    private View mockView;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(albumController).setSingleView(mockView).build();
    }

    @Test
    public void findByArtistTest() throws Exception {
        // given
        ArtistEntity artistEntity = new ArtistEntity("artistName");
        artistEntity.setId(1L);

        AlbumEntity album1 = new AlbumEntity("album1", artistEntity);
        AlbumEntity album2 = new AlbumEntity("album2", artistEntity);
        List<AlbumEntity> albumList = Arrays.asList(album1, album2);

        given(this.albumService.findByArtistId(1L)).willReturn(albumList);

        // when
        var resultList = this.albumController.findByArtist(artistEntity);

        // then
        assertThat(resultList, is(notNullValue()));
        assertThat(resultList.getStatusCode(), is(OK));
        var foundAlbum = resultList.getBody().get(0);
        assertThat(foundAlbum.getArtist().getName(), is("artistName"));
    }
}
