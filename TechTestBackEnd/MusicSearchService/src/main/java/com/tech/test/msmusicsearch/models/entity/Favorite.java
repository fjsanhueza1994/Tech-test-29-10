package com.tech.test.msmusicsearch.models.entity;

import jakarta.persistence.*;

@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "song_id")
    private Long songId;

    private String user;

    private String ranking;

    public Favorite() {}

    public Favorite(String artistName, Long songId, String user, String ranking) {
        this.artistName = artistName;
        this.songId = songId;
        this.user = user;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getartistName() {
        return artistName;
    }

    public void setartistName(String artistName) {
        this.artistName = artistName;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSong(Long songId) {
        this.songId = songId;
    }

    public String getuser() {
        return user;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}