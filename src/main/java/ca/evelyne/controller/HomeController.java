package ca.evelyne.controller;

import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Evelyne on 13/07/15.
 */

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String home() {
        return "homepage";
    }


    @RequestMapping("/allmovies")
    public String allmovies(Map<String, Object> model)   {
        model.put("movie", movieRepository.findAll());
        return "allmovies";
    }


    @RequestMapping("/actor/detail")
    public String actorDetailPage() {
        return "actordetail";
    }
}
