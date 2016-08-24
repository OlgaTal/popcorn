package com.compozed.services;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.entities.Studio;
import com.compozed.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 8/24/16.
 */

@Service
public class ActorService {

    private IActorRepository actorRepository;

    @Autowired
    public void setActorRepository(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Page<Actor> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.actorRepository.findAll(pr);
    }
    public Page<Movie> findAllMoviesByActorId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.actorRepository.findAllMoviesByActorId(id, pr);
    }

    public Page<Studio> findAllStudiosByActorId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.actorRepository.findAllStudiosByActorId(id, pr);
    }

    public Actor findOne(int id) {
        return this.actorRepository.findOne(id);
    }

    public Actor create(Actor m) {
        return this.actorRepository.save(m);
    }

    public void destroy(int id) {
        this.actorRepository.delete(id);
    }

    public Actor update(int id, Actor a) {
        Actor actor = this.actorRepository.findOne(id);
        actor.setName(a.getName());
        actor.setGender(a.getGender());
        return this.actorRepository.save(actor);
    }

}
