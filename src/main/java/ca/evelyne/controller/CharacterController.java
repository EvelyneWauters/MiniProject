package ca.evelyne.controller;

import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.repository.MovieCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    MovieCharacterRepository movieCharacterRepository;


    //Find all characters
    @RequestMapping("/all")
    public String allCharactersSortAlfa(Map<String, Object> model)   {
        model.put("movie", movieCharacterRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name"))));
        return "characterlist";
    }


    //find characters by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String characterById(Map<String, Object> model, @PathVariable("id") int characterId) {
        model.put("character", movieCharacterRepository.findOne(characterId));
        return "characterdetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String characterForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer characterId)    {
        if(characterId!=null)    {
            model.put("character", movieCharacterRepository.findOne(characterId));
        } else {
            model.put("character", new Actor());
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
        return "redirect:/character/all";
    }


    //delete characters
    @RequestMapping(value="/delete/id/{id}")
    public String deleteCharacter(@PathVariable("id") int characterId)    {
        movieCharacterRepository.delete(characterId);
        return "redirect:/character/all";
    }



}
