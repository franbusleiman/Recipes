package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeRepository recipeRepository;

    public IndexController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/index", " ", "/"})
    public String getRecetas(Model model){


        return "index.html";

    }
}
