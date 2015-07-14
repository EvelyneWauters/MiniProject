package ca.evelyne.controller;

import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.domain.person.User;
import ca.evelyne.repository.MovieCharacterRepository;
import ca.evelyne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    //Find all users
    @RequestMapping("/all")
    public String allUsersSortAlfa(Map<String, Object> model)   {
        model.put("movie", userRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "login"))));
        return "userlist";
    }


    //find users by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String characterById(Map<String, Object> model, @PathVariable("id") int userId) {
        model.put("user", userRepository.findOne(userId));
        return "userdetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String characterForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer userId)    {
        if(userId!=null)    {
            model.put("user", userRepository.findOne(userId));
        } else {
            model.put("user", new Actor());
        }
        return "characterform";
    }



    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "userform";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }


    //delete users
    @RequestMapping(value="/delete/id/{id}")
    public String deleteUser(@PathVariable("id") int userId)    {
        userRepository.delete(userId);
        return "redirect:/user/all";
    }


}
