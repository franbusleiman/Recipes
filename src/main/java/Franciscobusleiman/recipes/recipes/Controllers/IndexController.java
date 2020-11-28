package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public IndexController(){}

    @RequestMapping({"/index", " ", "/"})
    public String getRecetas(){


        return "index.html";

    }
}
