package com.tech.test.msmusicsearch.model;

import jakarta.persistence.*;

@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artistName;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    private String user;

    private String ranking;

    public Favorite() {}

    public Favorite(String artistName, Song song, String user, String ranking) {
        this.artistName = artistName;
        this.song = song;
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

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
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