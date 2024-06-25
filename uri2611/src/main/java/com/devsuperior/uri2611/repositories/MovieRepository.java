package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieIdNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name " +
            "FROM movies " +
            "INNER JOIN genres ON movies.id_genres = genres.id " +
            "WHERE UPPER(genres.description) " +
            "LIKE CONCAT('%', UPPER(:description), '%')")
    List<MovieIdNameProjection> findByDescription(String description);
}
