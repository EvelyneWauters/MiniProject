package ca.evelyne.controller;

import ca.evelyne.domain.film.Movie;
import ca.evelyne.repository.MovieRepository;
import ca.evelyne.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;


    //Find all movies
    @RequestMapping("/all")
    public String allMoviesSortAlfa(Map<String, Object> model)   {
        model.put("movie", movieRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "title"))));
        return "allmovies";
    }

    //find film by id and show details
   @RequestMapping(value = "/id/{id}", method = GET)
    public String movieById(Map<String, Object> model, @PathVariable("id") int movieId) {
        model.put("movie", movieRepository.findOne(movieId));
        return "moviedetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String form(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer filmId)    {
        if(filmId!=null)    {
            model.put("movie", movieRepository.findOne(filmId));
        } else {
            model.put("movie", new Movie());
        }
        return "movieform";
    }

    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String create(@Valid Movie movie, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "movieform";
        }
        movieRepository.save(movie);
        return "redirect:/movie/all";
    }

}
