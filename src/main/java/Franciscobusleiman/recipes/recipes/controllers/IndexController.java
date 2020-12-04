package Franciscobusleiman.recipes.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public IndexController(){}

    @RequestMapping({"/index", " ", "/"})
    public String getRecetas(){


        return "index.html";

    }
}
