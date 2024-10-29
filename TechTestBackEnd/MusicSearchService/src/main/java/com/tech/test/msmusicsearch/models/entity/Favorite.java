package com.tech.test.msmusicsearch.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name")
    @JsonProperty("nombre_banda")
    private String artistname;

    @Column(name = "song_id")
    @JsonProperty("cancion_id")
    private Long songId;

    @JsonProperty("usuario")
    private String username;

    @JsonProperty("ranking")
    private String ranking;

    public Favorite() {}

    public Favorite(String artistname, Long songId, String username, String ranking) {
        this.artistname = artistname;
        this.songId = songId;
        this.username = username;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistName) {
        this.artistname = artistName;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSong(Long songId) {
        this.songId = songId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}