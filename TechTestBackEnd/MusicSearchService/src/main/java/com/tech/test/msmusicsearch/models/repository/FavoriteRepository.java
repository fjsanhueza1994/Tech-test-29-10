package com.tech.test.msmusicsearch.models.repository;

import com.tech.test.msmusicsearch.models.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

   List<Favorite> findByUserName(String userName);

}