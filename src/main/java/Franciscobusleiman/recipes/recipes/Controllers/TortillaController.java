package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TortillaController {
    private final RecipeRepository recipeRepository;

    public TortillaController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/tortilla"})
    public String getRecetas(Model model){

Recipe tortilla = recipeRepository.findByDescription("tortilla").get();
model.addAttribute("tortilla", tortilla);
        return "tortilla.html";

    }
}

