package com.tech.test.msmusicsearch.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.test.msmusicsearch.exception.ExternalServiceException;
import com.tech.test.msmusicsearch.exception.FavoriteNotFoundException;
import com.tech.test.msmusicsearch.models.entity.Favorite;
import com.tech.test.msmusicsearch.models.repository.FavoriteRepository;
import com.tech.test.msmusicsearch.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final RestTemplate restTemplate;
    private static final String ITUNES_API_URL = "https://itunes.apple.com/search?term=";

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Retrieves a list of favorites by username.
     *
     * @param username the username of the user
     * @return list of favorites for the specified user
     */
    @Override
    public List<Favorite> findByUsername(String username) {
        return favoriteRepository.findByUsername(username);
    }

    /**
     * Deletes a favorite by its ID.
     *
     * @param favoriteId the ID of the favorite to delete
     */
    public void deleteById(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }

    /**
     * Adds a new favorite to the repository.
     *
     * @param favorite the favorite to add
     * @return the added favorite
     */
    public Favorite save(Favorite favorite) {
        if (!isFavoriteInItunes(favorite)) {
            throw new FavoriteNotFoundException("The song with ID " + favorite.getSongId() +
                    " for artist " + favorite.getArtistname() + " does not exist in songs API.");
        }

        return favoriteRepository.save(favorite);
    }

    /**
     * Verifies if the favorite song exists in the iTunes API for the given artist.
     *
     * @param favorite the favorite item to verify
     * @return true if the song exists on iTunes under the specified artist, false otherwise
     */
    private boolean isFavoriteInItunes(Favorite favorite) {
        String searchUrl = ITUNES_API_URL + favorite.getArtistname();
        try {
            String response = restTemplate.getForObject(searchUrl, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode results = root.path("results");

            for (JsonNode result : results) {
                long trackId = result.path("trackId").asLong();
                String artistName = result.path("artistName").asText();

                if (trackId == favorite.getSongId() && artistName.equalsIgnoreCase(favorite.getArtistname())) {
                    return true;
                }
            }

            throw new FavoriteNotFoundException("The favorite song does not exist for the specified artist");
        }  catch (IOException e) {
            throw new ExternalServiceException("Failed to parse API response", e);
        } catch (RestClientException e) {
            throw new ExternalServiceException("Failed to connect to API", e);
        }
    }
}
