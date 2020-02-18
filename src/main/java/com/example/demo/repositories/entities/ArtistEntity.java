package com.example.demo.repositories.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "id")
    private List<AlbumEntity> albumEntityList;

    public ArtistEntity() {
    }

    public ArtistEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlbumEntity> getAlbumEntityList() {
        return albumEntityList;
    }

    public void setAlbumEntityList(List<AlbumEntity> albumEntityList) {
        this.albumEntityList = albumEntityList;
    }
}
