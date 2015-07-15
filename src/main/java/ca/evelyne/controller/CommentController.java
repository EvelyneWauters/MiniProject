package ca.evelyne.controller;

import ca.evelyne.domain.movie.Comment;
import ca.evelyne.domain.movie.Movie;
import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.repository.ActorRepository;
import ca.evelyne.repository.CommentRepository;
import ca.evelyne.repository.MovieCharacterRepository;
import ca.evelyne.repository.MovieRepository;
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





}
