package ca.evelyne.controller;

import ca.evelyne.domain.movie.Movie;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.repository.MovieCharacterRepository;
import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    MovieCharacterRepository movieCharacterRepository;

    @Autowired
    MovieRepository movieRepository;


    //Find all characters
    @RequestMapping("/all")
    public String allCharactersSortAlfa(Map<String, Object> model)   {
        model.put("movieCharacter", movieCharacterRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name"))));
        return "characterlist";
    }


    //find characters by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String characterById(Map<String, Object> model, @PathVariable("id") int characterId) {
        model.put("character", movieCharacterRepository.findOne(characterId));
        return "characterdetail";
    }


//    //GET-method of the create-page
//    @RequestMapping(value="/form/id/{id}/movie/{movieId}", method = RequestMethod.GET)
//    public String characterForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer characterId, @PathVariable("movieId") int movieId)    {
//        if(characterId!=null)    {
//            model.put("character", movieCharacterRepository.findOne(characterId));
//        } else {
//            model.put("character", new MovieCharacter());
//        }
//        return "characterform";
//    }
//
//
//
//    //POST-method of the create-page
//    @RequestMapping(value= "/create", method = RequestMethod.POST)
//    public String createCharacter(@Valid MovieCharacter movieCharacter, BindingResult bindingResult, int movieId)  {
//        if(bindingResult.hasErrors())   {
//            return "characterform";
//        }
//        movieCharacterRepository.save(movieCharacter);
//        return "redirect:/movie/id/{movieId}";
//    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String characterForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer characterId)    {
        if(characterId!=null)    {
            model.put("character", movieCharacterRepository.findOne(characterId));
        } else {
            model.put("character", new MovieCharacter());
        }
        return "characterform";
    }



    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createCharacter(@Valid MovieCharacter movieCharacter, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "characterform";
        }
        movieCharacterRepository.save(movieCharacter);
        return "redirect:/movie/all";
    }



    //delete characters
    @RequestMapping(value="/delete/id/{id}/{movieId}")
    public String deleteCharacter(@PathVariable("id") int characterId, @PathVariable("movieId") int movieId)    {
        Movie movie = movieRepository.getOne(movieId);
        List<MovieCharacter> cast = movie.getCast();

        Iterator<MovieCharacter> it = movie.getCast().iterator();
        while(it.hasNext()) {
            MovieCharacter next = it.next();
            if(next.getId() == characterId)   {
                it.remove();
            }
        }

        movieRepository.save(movie);
        movieCharacterRepository.delete(characterId);
        return "redirect:/movie/id/{movieId}";
    }



}
