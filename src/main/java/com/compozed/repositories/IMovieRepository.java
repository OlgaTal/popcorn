package com.compozed.repositories;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.enums.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by localadmin on 8/24/16.
 */
public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    @Query("select distinct a from Movie m join m.actors a where a.id = :id")
    Page<Actor> findAllActorsByMovieId(@Param("id") int id, Pageable pageable);

    Movie findByName(String name);

    List<Movie> findByRatingOrderByReleasedDesc(Rating rating);
}
