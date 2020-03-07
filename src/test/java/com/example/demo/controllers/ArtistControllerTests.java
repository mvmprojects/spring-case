package com.example.demo.controllers;

import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.services.ArtistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ArtistController.class)
public class ArtistControllerTests {

    private ArtistController artistController;

    @MockBean
    private ArtistService artistService;

    @BeforeEach
    public void setup() throws Exception {
        artistService = mock(ArtistService.class);

        artistController = new ArtistController(artistService);
    }

    @Test
    public void findByNameTest() {
        // given
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName("artist");
        artistEntity.setId(1L);

        given(artistService.findByName(anyString())).willReturn(artistEntity);

        // when
        var result = artistController.findByName("artist");

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result.getStatusCode(), is(OK));
        assertThat(result.getBody(), is(notNullValue()));
        assertThat(result.getBody().getName(), is("artist"));
    }
}
