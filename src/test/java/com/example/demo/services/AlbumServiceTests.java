package com.example.demo.services;

import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
public class AlbumServiceTests {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Test
    public void findByArtistId_ShouldReturnAlbumsByArtistId() {
        // given
        ArtistEntity artistEntity = new ArtistEntity("artistName");
        ArtistEntity created = artistService.create(artistEntity);

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setArtist(created);
        albumEntity.setName("albumName");
        albumService.create(albumEntity);

        // when
        var resultList = albumService.findByArtistId(created.getId());

        // then
        assertThat(resultList, is(notNullValue()));
        assertThat(resultList.get(0).getName(), is("albumName"));
    }
}
