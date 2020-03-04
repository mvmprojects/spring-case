package com.example.demo.util;

import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;
import com.example.demo.services.AlbumService;
import com.example.demo.services.ArtistService;
import com.example.demo.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private ArtistService artistService;
    private AlbumService albumService;
    private TrackService trackService;

    @Autowired
    public DataLoader(ArtistService artistService, AlbumService albumService, TrackService trackService) {
        this.artistService = artistService;
        this.albumService = albumService;
        this.trackService = trackService;
    }

    //load into in-memory database
    public void run(ApplicationArguments args) {
        this.createData();
    }

    private void createData() {
        ArtistEntity artistEntity = new ArtistEntity("Michael Jackson");
        ArtistEntity mj = artistService.create(artistEntity);

        AlbumEntity thriller = new AlbumEntity("Thriller", mj);
        AlbumEntity thrillerE = albumService.create(thriller);
        AlbumEntity bad = new AlbumEntity("Bad", mj);
        AlbumEntity badE = albumService.create(bad);

        TrackEntity track1 = new TrackEntity("Beat It", thrillerE,3);
        TrackEntity track2 = new TrackEntity("The Way You Make Me Feel", badE,3);

        trackService.create(track1);
        trackService.create(track2);

        ArtistEntity artistEntity2 = new ArtistEntity("Jimi Hendrix");
        ArtistEntity jh = artistService.create(artistEntity2);

        AlbumEntity smashHits = new AlbumEntity("Smash Hits", jh);
        AlbumEntity smashHitsE = albumService.create(smashHits);
        AlbumEntity electricLadyland = new AlbumEntity("Electric Ladyland", jh);
        AlbumEntity electricLadylandE = albumService.create(electricLadyland);

        TrackEntity track3 = new TrackEntity("Track A", smashHitsE,1);
        TrackEntity track4 = new TrackEntity("Track B", smashHitsE,2);
        TrackEntity track5 = new TrackEntity("Track C", smashHitsE,3);
        TrackEntity track6 = new TrackEntity("Track A", electricLadylandE,1);
        TrackEntity track7 = new TrackEntity("Track B", electricLadylandE,2);
        TrackEntity track8 = new TrackEntity("Track C", electricLadylandE,3);

        trackService.create(track3);
        trackService.create(track4);
        trackService.create(track5);
        trackService.create(track6);
        trackService.create(track7);
        trackService.create(track8);

        ArtistEntity artistEntity3 = new ArtistEntity("Demo Artist A");
        ArtistEntity daa = artistService.create(artistEntity3);

        AlbumEntity demoAlbum1 = new AlbumEntity("Demo Album 1", daa);
        AlbumEntity demoAlbum1E = albumService.create(demoAlbum1);
        AlbumEntity demoAlbum2 = new AlbumEntity("Demo Album 2", daa);
        AlbumEntity demoAlbum2E = albumService.create(demoAlbum2);

        TrackEntity track9 = new TrackEntity("Track A", demoAlbum1E,1);
        TrackEntity track10 = new TrackEntity("Track B", demoAlbum1E,2);
        TrackEntity track11 = new TrackEntity("Track C", demoAlbum1E,3);
        TrackEntity track12 = new TrackEntity("Track A", demoAlbum2E,1);
        TrackEntity track13 = new TrackEntity("Track B", demoAlbum2E,2);
        TrackEntity track14 = new TrackEntity("Track C", demoAlbum2E,3);

        trackService.create(track9);
        trackService.create(track10);
        trackService.create(track11);
        trackService.create(track12);
        trackService.create(track13);
        trackService.create(track14);

        ArtistEntity artistEntity4 = new ArtistEntity("Demo Artist B");
        ArtistEntity dab = artistService.create(artistEntity4);

        AlbumEntity demoAlbum3 = new AlbumEntity("Demo Album 1", dab);
        AlbumEntity demoAlbum3E = albumService.create(demoAlbum3);
        AlbumEntity demoAlbum4 = new AlbumEntity("Demo Album 2", dab);
        AlbumEntity demoAlbum4E = albumService.create(demoAlbum4);

        TrackEntity track15 = new TrackEntity("Track A", demoAlbum3E,1);
        TrackEntity track16 = new TrackEntity("Track B", demoAlbum3E,2);
        TrackEntity track17 = new TrackEntity("Track C", demoAlbum3E,3);
        TrackEntity track18 = new TrackEntity("Track A", demoAlbum4E,1);
        TrackEntity track19 = new TrackEntity("Track B", demoAlbum4E,2);
        TrackEntity track20 = new TrackEntity("Track C", demoAlbum4E,3);

        trackService.create(track15);
        trackService.create(track16);
        trackService.create(track17);
        trackService.create(track18);
        trackService.create(track19);
        trackService.create(track20);

        ArtistEntity artistEntity5 = new ArtistEntity("Demo Artist C");
        ArtistEntity dac = artistService.create(artistEntity5);

        AlbumEntity demoAlbum5 = new AlbumEntity("Demo Album 1", dac);
        AlbumEntity demoAlbum5E = albumService.create(demoAlbum5);
        AlbumEntity demoAlbum6 = new AlbumEntity("Demo Album 2", dac);
        AlbumEntity demoAlbum6E = albumService.create(demoAlbum6);

        TrackEntity track21 = new TrackEntity("Track A", demoAlbum5E,1);
        TrackEntity track22 = new TrackEntity("Track B", demoAlbum5E,2);
        TrackEntity track23 = new TrackEntity("Track C", demoAlbum5E,3);
        TrackEntity track24 = new TrackEntity("Track A", demoAlbum6E,1);
        TrackEntity track25 = new TrackEntity("Track B", demoAlbum6E,2);
        TrackEntity track26 = new TrackEntity("Track C", demoAlbum6E,3);

        trackService.create(track21);
        trackService.create(track22);
        trackService.create(track23);
        trackService.create(track24);
        trackService.create(track25);
        trackService.create(track26);
    }
}
