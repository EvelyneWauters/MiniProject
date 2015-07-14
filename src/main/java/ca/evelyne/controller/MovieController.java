package ca.evelyne.controller;

import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Evelyne on 14/07/15.
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;


    @RequestMapping("/all")
    public String allmovies(Map<String, Object> model)   {
        model.put("movie", movieRepository.findAll());
        return "allmovies";
    }

    @RequestMapping("/detail")
    public String film(Map<String, Object> model, @RequestParam("id") int filmId) {
        model.put("movie", movieRepository.findOne(filmId));
        return "moviedetail";
    }
}
