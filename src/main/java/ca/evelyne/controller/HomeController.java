package ca.evelyne.controller;

import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Evelyne on 13/07/15.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "homepage";
    }




}
