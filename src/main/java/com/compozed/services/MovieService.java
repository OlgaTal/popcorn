package com.compozed.services;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.entities.Studio;
import com.compozed.enums.Rating;
import com.compozed.repositories.IMovieRepository;
import com.compozed.repositories.IStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by localadmin on 8/24/16.
 */

@Service
public class MovieService {

    private IMovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Page<Movie> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.movieRepository.findAll(pr);
    }

    public Movie findByName(String name) {
       return this.movieRepository.findByName(name);
    }

    public Movie findOne(int id) {
        return this.movieRepository.findOne(id);
    }

    public List<Movie> findByRatingOrderByReleasedDesc(Rating rating) {
        return this.movieRepository.findByRatingOrderByReleasedDesc(rating);
    }


    public Movie create(Movie m) {
        return this.movieRepository.save(m);
    }

    public void destroy(int id) {
        this.movieRepository.delete(id);
    }

    public Movie update(int id, Movie m) {
        Movie movie = this.movieRepository.findOne(id);
        movie.setName(m.getName());
        movie.setGenre(m.getGenre());
        return this.movieRepository.save(movie);
    }

    public Page<Actor> findAllMoviesByActorId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.movieRepository.findAllActorsByMovieId(id, pr);
    }
}
