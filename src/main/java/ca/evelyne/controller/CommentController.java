package ca.evelyne.controller;

import ca.evelyne.domain.movie.Comment;
import ca.evelyne.domain.movie.Movie;
import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository  movieRepository;

    @Autowired
    UserRepository userRepository;


    //Find all comments per movie
    @RequestMapping("/all")
    public String allCommentsPerMovieSortOnDate(Map<String, Object> model, @RequestParam("id") int movieId)   {
        List<Comment> allComments = commentRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "dateAdded")));
        List<Comment> commentsPerMovie = new ArrayList<>();

        for (Comment comment : allComments) {
            if(comment.getMovie().getId() == movieId)    {
                commentsPerMovie.add(comment);
            }
        }
        model.put("comment", commentsPerMovie);
        return "commentlist";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String commentForm(Map<String, Object> model, @RequestParam(value = "id") Integer movieId)    {
        model.put("comment", new Comment());
        return "commentform";
    }

    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createCharacter(@Valid Comment comment, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "commentform";
        }
        if(userRepository.findUserByLogin(comment.getUser().getLogin()) --!= null)
        commentRepository.save(comment);
        return "redirect:/all?id={movieId}";
    }





}
