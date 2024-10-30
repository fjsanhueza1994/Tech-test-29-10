package com.tech.test.msmusicsearch.controller;

import com.tech.test.msmusicsearch.models.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/music-search")
public class MusicSearchController {

    private final FavoriteServiceImpl favoriteServiceImpl;
    private final MusicSearchServiceImpl musicSearchServiceImpl;

    @Autowired
    public MusicSearchController(FavoriteServiceImpl favoriteServiceImpl, MusicSearchServiceImpl musicSearchServiceImpl) {
        this.favoriteServiceImpl = favoriteServiceImpl;
        this.musicSearchServiceImpl = musicSearchServiceImpl;
    }

    @GetMapping("/search_tracks/{searchTerm}")
    public ResponseEntity<?> searchTracks(@PathVariable String searchTerm) {
        try {
            return ResponseEntity.ok(musicSearchServiceImpl.searchSongs(searchTerm));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves favorites by username.
     *
     * @param username the username of the user
     * @return list of favorites for the specified user
     */
    @GetMapping("/favoritos-usuario/{username}")
    public ResponseEntity<List<Favorite>> findByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.ok(favoriteServiceImpl.findByUsername(username));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Adds a new favorite item.
     *
     * @param favorite the favorite item to add
     * @return the added favorite item
     */
    @PostMapping("/favoritos")
    public ResponseEntity<String> addFavorite(@RequestBody Favorite favorite) {
        try {
            favoriteServiceImpl.save(favorite);
            return ResponseEntity.ok("La canción favorita fue guardada correctamente");

        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando la canción favorita", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a favorite by its ID.
     *
     * @param favoriteId the ID of the favorite to delete
     * @return response indicating the status of deletion
     */
    @DeleteMapping("borrar-favoritos/{favoriteId}")
    public ResponseEntity<String> deleteFavorite(@PathVariable Long favoriteId) {
        try {
            favoriteServiceImpl.deleteById(favoriteId);
            return ResponseEntity.ok("La canción favorita fue eliminada");
        } catch (Exception e) {
            return new ResponseEntity<>("Error eliminando la canción favorita", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
