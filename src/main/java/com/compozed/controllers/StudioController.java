package com.compozed.controllers;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.entities.Studio;
import com.compozed.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/studios")
public class StudioController {

    private StudioService studioService;

    @Autowired
    public void setStudioService(StudioService studioService) {
        this.studioService = studioService;
    }

    @RequestMapping(path={"", "/"}, method= RequestMethod.GET)
    public Page<Studio> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {

        return studioService.findAll(page);

    }

    @RequestMapping(path={"/{id}/movies"}, method= RequestMethod.GET)
    public Page<Movie> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {

        return studioService.findAllMoviesByStudioId(id, page);

    }

    @RequestMapping(path={"/{id}/actors"}, method= RequestMethod.GET)
    public Page<Actor> actors(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {

        return studioService.findAllActorsByStudioId(id, page);

    }

    @RequestMapping(path={"", "/"}, method= RequestMethod.POST)
    public Studio create(@RequestBody Studio studio) {

        return this.studioService.create(studio);

    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.studioService.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Studio destroy(@PathVariable int id, @RequestBody Studio studio) {
        return this.studioService.update(id, studio);
    }
}
