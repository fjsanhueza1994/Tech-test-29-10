package com.tech.test.msmusicsearch.controller;

import com.tech.test.msmusicsearch.models.entity.Favorite;
import com.tech.test.msmusicsearch.models.repository.FavoriteRepository;
import com.tech.test.msmusicsearch.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
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
     * Adds a new favorite to the repository.
     *
     * @param favorite the favorite to add
     * @return the added favorite
     */
    public Favorite save(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    /**
     * Deletes a favorite by its ID.
     *
     * @param favoriteId the ID of the favorite to delete
     */
    public void deleteById(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}
