package com.compozed.repositories;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.entities.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IStudioRepository extends PagingAndSortingRepository<Studio, Integer> {

    @Query("select m from Movie m join m.studio s where s.id = :id")
    Page<Movie> findAllMoviesByStudioId(@Param("id") int id, Pageable pageable);

    @Query("select distinct a from Movie m join m.studio s join m.actors a where s.id = :id")
    Page<Actor> findAllActorsByStudioId(@Param("id") int id, Pageable pageable);

}
