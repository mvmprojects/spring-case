package com.example.demo.services;

import com.example.demo.repositories.TrackRepository;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class TrackServiceTests {
//    @InjectMocks
    @Autowired
    private TrackService trackService;

    @Autowired
    private AlbumService albumService;

//    @Mock
//    private TrackRepository trackRepositoryMock;
//
//    @BeforeEach
//    public void setup() {
//        initMocks(this);
//    }

    @Test
    public void ShouldSaveTrackEntity() {
        // given
        TrackEntity trackRequest = new TrackEntity();
        trackRequest.setName("trackName");
        trackRequest.setDuration(3);

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName("albumName");
        albumEntity.setId((long) 1);
        albumService.create(albumEntity);

        trackRequest.setAlbum(albumEntity);

//        when(trackRepositoryMock.save(any(TrackEntity.class))).thenReturn(trackRequest);
        // when
//        var result =_sut.save(trackRequest);
//        trackService.create(trackRequest);
        var result = trackService.findAll();
        // then
        assertThat(result, is(notNullValue()));
//        assertThat(result.getName(), is("trackName"));
//        assertThat(result.getDuration(), is(3));
    }

    @Test
    public void findByAlbum_ShouldReturnTracksByAlbum() {

    }
}
