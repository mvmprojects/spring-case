package com.example.demo.mappers;

import com.example.demo.controllers.dtos.ArtistDto;
import com.example.demo.repositories.entities.ArtistEntity;

public class ArtistMapper {
    public static ArtistDto artistEntityToArtistDto(ArtistEntity artistEntity) {
        ArtistDto artistDto = new ArtistDto();
        artistDto.setId(artistEntity.getId());
        artistDto.setName(artistEntity.getName());

        return artistDto;
    }
//    public static ArtistEntity artistDtoToArtistEntity(ArtistDto artistDto) {
//
//    }
}
