package com.compozed.controllers;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.entities.Studio;
import com.compozed.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/actors")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(path={"", "/"}, method= RequestMethod.GET)
    public Page<Actor> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {

        return actorService.findAll(page);

    }

    @RequestMapping(path = {"/{id}/movies"}, method = RequestMethod.GET)
    public Page<Movie> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.actorService.findAllMoviesByActorId(id, page);
    }

    @RequestMapping(path = {"/{id}/studios"}, method = RequestMethod.GET)
    public Page<Studio> studios(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.actorService.findAllStudiosByActorId(id, page);
    }

    @RequestMapping(path={"", "/"}, method= RequestMethod.POST)
    public Actor create(@RequestBody Actor actor) {

        return this.actorService.create(actor);

    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.actorService.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Actor destroy(@PathVariable int id, @RequestBody Actor actor) {
        return this.actorService.update(id, actor);
    }
}
