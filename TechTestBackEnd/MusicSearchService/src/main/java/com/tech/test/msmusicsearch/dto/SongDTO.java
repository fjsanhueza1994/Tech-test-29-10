package com.tech.test.msmusicsearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class SongDTO {
    private Long songId;
    @JsonProperty("nombre_album")
    private String albumName;
    @JsonProperty("nombre_cancion")
    private String songName;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("fecha_lanzamiento")
    private LocalDate releaseDate;
    @JsonProperty("precio")
    private Price price;

    public SongDTO() {
    }

    public SongDTO(Long songId, String albumName, String songName, String previewUrl, LocalDate releaseDate, Price price) {
        this.songId = songId;
        this.albumName = albumName;
        this.songName = songName;
        this.previewUrl = previewUrl;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
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
}
