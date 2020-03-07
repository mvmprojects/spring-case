package com.example.demo.services;

import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.util.DataLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
public class ArtistServiceTests {

    @Autowired
    private ArtistService artistService;

    @Test
    public void findByName_ShouldReturnArtistByName() {
        // given
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName("name");
        artistService.create(artistEntity);

        // when
        var result = artistService.findByName("name");

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result.getName(), is("name"));
    }
}
