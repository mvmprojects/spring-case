package com.example.demo.mappers;

import com.example.demo.controllers.dtos.AlbumDto;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import org.jetbrains.annotations.NotNull;

public class AlbumMapper {

    public static AlbumEntity albumDtoToAlbumEntity(AlbumDto albumDto) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setId(albumDto.getId());
        albumEntity.setName(albumDto.getName());

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setId(albumDto.getArtistId());
        artistEntity.setName(albumDto.getArtistName());
        albumEntity.setArtist(artistEntity);

        return albumEntity;
    }

    public static AlbumDto albumEntityToAlbumDto(AlbumEntity albumEntity) {
        AlbumDto albumDto = new AlbumDto();
        albumDto.setId(albumEntity.getId());
        albumDto.setName(albumEntity.getName());
        albumDto.setArtistId(albumEntity.getArtist().getId());
        albumDto.setArtistName(albumEntity.getArtist().getName());

        return albumDto;
    }
}
