package com.tech.test.msmusicsearch.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_album")
    private String albumName;

    @Column(name = "nombre_tema")
    private String songName;

    @Column(name = "preview_url")
    private String previewUrl;

    @Column(name = "fecha_lanzamiento")
    private LocalDate releaseDate;

    @Embedded
    private Price price;

    public Song() {}

    public Song(String albumName, String songName, String previewUrl, LocalDate releaseDate, Price price) {
        this.albumName = albumName;
        this.songName = songName;
        this.previewUrl = previewUrl;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
