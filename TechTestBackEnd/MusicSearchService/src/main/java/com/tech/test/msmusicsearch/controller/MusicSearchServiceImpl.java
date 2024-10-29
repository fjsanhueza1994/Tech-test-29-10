package com.tech.test.msmusicsearch.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.test.msmusicsearch.dto.MusicSearchResponseDTO;
import com.tech.test.msmusicsearch.dto.Price;
import com.tech.test.msmusicsearch.dto.SongDTO;
import com.tech.test.msmusicsearch.service.MusicSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MusicSearchServiceImpl implements MusicSearchService {

    private static final String ITUNES_API_URL = "https://itunes.apple.com/search?term=";

    private final RestTemplate restTemplate;

    @Autowired
    public MusicSearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Searches for songs based on a given search term and filters results to include only
     * songs from a specified artist. Limits the result to a maximum of 25 songs,
     * calculates unique albums, and returns a structured response containing the album and song data.
     *
     * @param searchTerm the term to search for songs on the iTunes API
     * @return a structured response containing the total unique albums, total songs,
     *         a list of album names, and song details
     */
    public MusicSearchResponseDTO searchSongs(String searchTerm) {
        List<SongDTO> songList = new ArrayList<>();

        try {
            String url = ITUNES_API_URL + searchTerm.replace(" ","+") + "&media=music&entity=song";
            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode results = root.path("results");

            for (JsonNode result : results) {
                String artistName = result.path("artistName").asText();
                if (!artistName.replaceAll("[ +]", "").equalsIgnoreCase(
                        searchTerm.replaceAll("[ +]", ""))
                ) {
                    continue;
                }

                Long songId = result.path("trackId").asLong();
                String albumName = result.path("collectionName").asText();
                String songName = result.path("trackName").asText();
                String previewUrl = result.path("previewUrl").asText();
                String currency = result.path("currency").asText();
                double priceValue = result.path("trackPrice").asDouble();
                LocalDate releaseDate = LocalDate.parse(result.path("releaseDate").asText().substring(0, 10));


                SongDTO songDTO = new SongDTO(songId, albumName, songName, previewUrl, releaseDate, new Price(priceValue, currency));
                songList.add(songDTO);
            }

            songList = songList.stream().limit(25).collect(Collectors.toList());

            Set<String> uniqueAlbums = songList.stream()
                    .map(SongDTO::getAlbumName)
                    .collect(Collectors.toSet());

            List<String> albumList = new ArrayList<>(uniqueAlbums);

            return new MusicSearchResponseDTO(
                    albumList.size(),
                    songList.size(),
                    albumList,
                    songList
            );

        } catch (IOException e) {
          throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error parsing API response", e);
        }
    }
}
