package com.compozed.controllers;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.enums.Rating;
import com.compozed.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by localadmin on 8/24/16.
 */

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(path={"", "/"}, method= RequestMethod.GET)
    public Page<Movie> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {

        return movieService.findAll(page);

    }

    @RequestMapping(path={"", "/"}, method= RequestMethod.POST)
    public Movie create(@RequestBody Movie movie) {

        return this.movieService.create(movie);

    }

    @RequestMapping(path = {"/name/{name}"}, method = RequestMethod.GET)
    public Movie findByName(@PathVariable String name) {
        return this.movieService.findByName(name);
    }

    @RequestMapping(path = {"/rating/{rating}"}, method = RequestMethod.GET)
    public List<Movie> findByRatingOrderByReleasedDesc(@PathVariable Rating rating) {
        return this.movieService.findByRatingOrderByReleasedDesc(rating);
    }

    @RequestMapping(path = {"/{id}/actors"}, method = RequestMethod.GET)
    public Page<Actor> actors(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.movieService.findAllMoviesByActorId(id, page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.movieService.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Movie destroy(@PathVariable int id, @RequestBody Movie movie) {
        return this.movieService.update(id, movie);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Movie show(@PathVariable int id) {
        return this.movieService.findOne(id);
    }

}
