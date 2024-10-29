package com.tech.test.msmusicsearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MusicSearchResponseDTO {

    @JsonProperty("total_albumes")
    private int totalCollections;
    @JsonProperty("total_canciones")
    private int totalSongs;
    @JsonProperty("albumes")
    private List<String> collections;
    @JsonProperty("canciones")
    private List<SongDTO> songs;

    public MusicSearchResponseDTO(int totalCollections, int totalSongs, List<String> collections, List<SongDTO> songs) {
        this.totalCollections = totalCollections;
        this.totalSongs = totalSongs;
        this.collections = collections;
        this.songs = songs;
    }

    public int getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(int totalCollections) {
        this.totalCollections = totalCollections;
    }

    public int getTotalSongs() {
        return totalSongs;
    }

    public void setTotalSongs(int totalSongs) {
        this.totalSongs = totalSongs;
    }

    public List<String> getCollections() {
        return collections;
    }

    public void setCollections(List<String> collections) {
        this.collections = collections;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
    }
}