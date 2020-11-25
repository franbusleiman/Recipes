package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class TortillaController {
    private final RecipeRepository recipeRepository;

    public TortillaController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/tortilla"})
    public String getRecetas(Model model){
 log.debug("Enviando a pantalla info. de la receta de tortilla");
Recipe tortilla = recipeRepository.findByDescription("tortilla").get();
model.addAttribute("tortilla", tortilla);
        return "tortilla.html";

    }
}

