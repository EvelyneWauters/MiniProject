package ca.evelyne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
