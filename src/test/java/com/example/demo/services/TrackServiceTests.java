package com.example.demo.services;

import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class TrackServiceTests {

    @Autowired
    private TrackService trackService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Test
    public void ShouldCreateUpdateDeleteTrack() {
        // given
        ArtistEntity artistEntity = new ArtistEntity("artist");
        ArtistEntity createdArtist = artistService.create(artistEntity);

        AlbumEntity albumEntity = new AlbumEntity("album", createdArtist);
        AlbumEntity createdAlbum = albumService.create(albumEntity);

        TrackEntity trackRequest = new TrackEntity("track", createdAlbum,2);
        trackService.create(trackRequest);

        // when
        var resultList = trackService.findAll();
        TrackEntity foundTrack = resultList.get(0);
        assertThat(foundTrack, is(notNullValue()));
        assertThat(foundTrack.getName(), is("track"));

        foundTrack.setName("updatedTrack");
        trackService.update(foundTrack);

        // then
        TrackEntity foundTrack2 = trackService.findAll().get(0);
        assertThat(foundTrack2, is(notNullValue()));
        assertThat(foundTrack2.getName(), is("updatedTrack"));

        // clean up
        trackService.delete(foundTrack2.getId());
    }

    @Test
    public void findByAlbum_ShouldReturnTracksByAlbum() {
        // given
        ArtistEntity artistEntity = new ArtistEntity("artistName");
        ArtistEntity createdArtist = artistService.create(artistEntity);

        AlbumEntity albumEntity = new AlbumEntity("albumName", createdArtist);
        AlbumEntity createdAlbum = albumService.create(albumEntity);

        TrackEntity trackRequest = new TrackEntity("trackName", createdAlbum,3);

        // when
        trackService.create(trackRequest);

        var resultList = trackService.findAll();
        assertThat(resultList, is(notNullValue()));
        assertThat(resultList.get(0).getName(), is("trackName"));
        assertThat(resultList.get(0).getDuration(), is(3));

        // then
        var resultList2 = trackService.findByAlbumId(createdAlbum.getId());
        assertThat(resultList2, is(notNullValue()));
        assertThat(resultList2.get(0).getName(), is("trackName"));
        assertThat(resultList2.get(0).getDuration(), is(3));

        // clean up
        trackService.delete(resultList.get(0).getId());
    }
}
