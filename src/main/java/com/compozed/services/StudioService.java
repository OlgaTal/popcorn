package com.compozed.services;

import com.compozed.entities.Actor;
import com.compozed.entities.Movie;
import com.compozed.entities.Studio;
import com.compozed.repositories.IStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 8/24/16.
 */

@Service
public class StudioService {

    private IStudioRepository studioRepository;

    @Autowired
    public void setStudioRepository(IStudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public Page<Movie> findAllMoviesByStudioId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.studioRepository.findAllMoviesByStudioId(id, pr);
    }

    public Page<Actor> findAllActorsByStudioId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.studioRepository.findAllActorsByStudioId(id, pr);
    }

    public Page<Studio> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.studioRepository.findAll(pr);
    }

    public Studio create(Studio s) {
       return this.studioRepository.save(s);
    }

    public void destroy(int id) {
        this.studioRepository.delete(id);
    }

    public Studio update(int id, Studio s) {
        Studio studio = this.studioRepository.findOne(id);
        studio.setName(s.getName());
        studio.setEst(s.getEst());
        return this.studioRepository.save(studio);
    }

}
