package com.tech.test.msmusicsearch.service;

import com.tech.test.msmusicsearch.dto.MusicSearchResponseDTO;

import java.io.IOException;

public interface MusicSearchService {

    public MusicSearchResponseDTO searchSongs(String searchTerm) throws IOException;

}
