package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class GuacamoleController {
    private final RecipeRepository recipeRepository;

    public GuacamoleController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/guacamole"})
    public String getRecetas(Model model){

Recipe guacamole = recipeRepository.findByDescription("Guacamole").get();
model.addAttribute("guacamole", guacamole);
        return "guacamole.html";

    }
}
