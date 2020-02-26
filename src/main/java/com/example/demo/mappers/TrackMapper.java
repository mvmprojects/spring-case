package com.example.demo.mappers;

import com.example.demo.controllers.dtos.TrackDto;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;

public class TrackMapper {

    public static TrackDto trackEntityToTrackDto(TrackEntity trackEntity) {
        TrackDto trackDto = new TrackDto();
        trackDto.setId(trackEntity.getId());
        trackDto.setName(trackEntity.getName());
        trackDto.setAlbumId(trackEntity.getAlbum().getId());
        trackDto.setAlbumName(trackEntity.getAlbum().getName());
        trackDto.setArtistId(trackEntity.getAlbum().getArtist().getId());
        trackDto.setArtistName(trackEntity.getAlbum().getArtist().getName());
        trackDto.setDuration(trackEntity.getDuration());

        return trackDto;
    }

    public static TrackEntity trackDtoToTrackEntity(TrackDto trackDto) {
        TrackEntity trackEntity = new TrackEntity();
        trackEntity.setId(trackDto.getId());
        trackEntity.setName(trackDto.getName());
        trackEntity.setDuration(trackDto.getDuration());

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setId(trackDto.getAlbumId());
        albumEntity.setName(trackDto.getAlbumName());

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setId(trackDto.getArtistId());
        artistEntity.setName(trackDto.getArtistName());

        albumEntity.setArtist(artistEntity);
        trackEntity.setAlbum(albumEntity);

        return trackEntity;
    }
}
