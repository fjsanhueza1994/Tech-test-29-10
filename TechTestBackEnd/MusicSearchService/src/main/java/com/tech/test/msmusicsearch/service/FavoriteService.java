package com.tech.test.msmusicsearch.service;

import com.tech.test.msmusicsearch.models.entity.Favorite;

import java.util.List;

public interface FavoriteService {

    public List<Favorite> findByUsername(String username);
    public Favorite save(Favorite favorite);
    public void deleteById(Long favoriteId);

}
